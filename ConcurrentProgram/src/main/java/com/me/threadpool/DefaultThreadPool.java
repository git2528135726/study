package com.me.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 拥有任务列队，和工作列队
 * @param <Job>
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //线程池最小线程数
    private static final int MIN_WORKER_NUMBERS =1;

    //工作列表，工作将先提交到里面
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    //工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程的数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }
    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS:
                (num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num);
        initializeWorkers(workerNum);
    }

    public void execute(Job job) {
        if(job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for (Worker worker: workers) {
            worker.shutdown();
        }
    }

    public void addWorkers(int num) {
        synchronized (jobs) {//这里不能写成synchronized(workers)
            int addNum = (this.workerNum+num) > MAX_WORKER_NUMBERS?(MAX_WORKER_NUMBERS-this.workerNum):num;
            initializeWorkers(addNum);
            this.workerNum += addNum;
        }
    }

    public void removeWorker(int num) {
        synchronized (jobs) {
            //int decreaseNum = num>(this.workerNum-MIN_WORKER_NUMBERS)?(this.workerNum-MIN_WORKER_NUMBERS):num;
            if(num >= this.workerNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while(count < num) {
                Worker worker = workers.get(count);
                if(workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }

    public int getJobSize() {
        return jobs.size();
    }

    //初始化工作列队
    private void initializeWorkers(int num) {
        for (int i=0; i<num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable {
        //是否工作
        private volatile boolean running = true;
        public void run() {
            while(running) {
                Job job = null;
                synchronized (jobs) {
                    //如果工作者列表是空的，那么就wait
                    while(jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        }catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    //取出一个Job
                    job = jobs.removeFirst();
                }
                if(job != null) {
                    try {
                        job.run();
                    }catch (Exception ex) {
                        //忽略Job执行中的Exception
                    }
                }
            }
        }
        public void shutdown() {
            running = false;
        }
    }

}

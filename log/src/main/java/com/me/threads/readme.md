#中断线程
####1、中断条件
    1、run由执行return方法返回时，或者在方法中没有捕获的异常时，线程将终止
    2、没有强制线程终止的方法，interrupt方法可以用来请求终止线程
    3、当对一个线程调用interrupt方法时，线程的中断状态将被置位
    4、while(!Thread.currentThread().isInterrupted() && more work to do) {
        do more work;
    }
    5、如果线程被阻塞，就无法检测中断状态，这是产生InterruptedException异常的地方，当在一个被阻塞
    的线程（sleep、wait）上调用interrupt方法时，阻塞将被Interrupted Exception异常中断，存在不能被中断
    的阻塞i/o调用，应该考虑选择可中断的调用
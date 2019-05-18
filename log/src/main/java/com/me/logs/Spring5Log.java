package com.me.logs;

import com.me.logs.config.AppConfig;
import com.me.logs.config.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring5 内置的是 spring jcl，是spring对jcl的封装
 * Detects the presence of Log4j 2.x / SLF4J, falling back to {@code java.util.logging}.
 */
public class Spring5Log {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AppConfig.class);
        annotationConfigApplicationContext.refresh();

        Service service = (Service)annotationConfigApplicationContext.getBean(Service.class);
        service.service();

    }
}

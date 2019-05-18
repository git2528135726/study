package com.me.logs;

import com.me.logs.config.AppConfig;
import com.me.logs.config.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 4 内用的 jcl
 */
public class SpringLog {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AppConfig.class);
        annotationConfigApplicationContext.refresh();

        Service service = (Service)annotationConfigApplicationContext.getBean(Service.class);
        service.service();

    }
}

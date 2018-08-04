package com.gycheng.bootdemo.study.crontask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledTaskConfig.class);

    }
}

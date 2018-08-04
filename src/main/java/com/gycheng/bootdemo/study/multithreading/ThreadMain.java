package com.gycheng.bootdemo.study.multithreading;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ThreadMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskExecutorAsyncConfig.class);

        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for(int i=1; i<10; i++){
            asyncTaskService.execAsyncTask(i);
            asyncTaskService.execAsyncTaskPlus(i);
        }

        context.close();
    }
}

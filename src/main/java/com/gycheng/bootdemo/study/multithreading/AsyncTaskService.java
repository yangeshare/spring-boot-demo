package com.gycheng.bootdemo.study.multithreading;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async
    public void execAsyncTask(int i){
        System.out.println(String.format("common task %d exec", i));
    }

    @Async
    public void execAsyncTaskPlus(int i){
        System.out.println(String.format("advance task %d+ exec", i));
    }
}

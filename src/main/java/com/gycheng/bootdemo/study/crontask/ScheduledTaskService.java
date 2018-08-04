package com.gycheng.bootdemo.study.crontask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate=10*60*1000)
    public void reportCurrentTime(){
        System.out.println(String.format("every 5s execute: %s", dateFormat.format(new Date())));
    }

    @Scheduled(cron = "0 0/30 12-18 * * ?")
    public void fixTimeExecution(){
        System.out.println(String.format("exec at fix time: %s", dateFormat.format(new Date())));
    }
}

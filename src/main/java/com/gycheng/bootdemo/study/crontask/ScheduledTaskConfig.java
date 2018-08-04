package com.gycheng.bootdemo.study.crontask;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.gycheng.bootdemo.study.crontask")
@EnableScheduling
public class ScheduledTaskConfig {
}

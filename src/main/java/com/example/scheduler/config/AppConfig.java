package com.example.scheduler.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.example.scheduler.service.PrintService;

@Configuration
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskScheduler());
        taskRegistrar.addTriggerTask(() -> myTask().run(), myTrigger());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(42);
    }

    @Bean
    public CustomDynamicSchedule myTrigger() {
        return new CustomDynamicSchedule();
    }

    @Bean
    public PrintService myTask() {
        return new PrintService();
    }
}

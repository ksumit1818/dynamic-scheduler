package com.example.scheduler.config;

import java.util.Date;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

public class CustomDynamicSchedule extends DynamicSchedule implements Trigger {

	private long delayInterval;

    @Override
    public synchronized void increaseDelayInterval(Long delay) {
        this.delayInterval += delay;
    }

    @Override
    public synchronized void decreaseDelayInterval(Long delay) {
        this.delayInterval += delay;
    }

    @Override
    public synchronized void delay(Long delay) {
        this.delayInterval = delay;
    }

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        Date lastTime = triggerContext.lastActualExecutionTime();
        System.out.println("last run:  "+lastTime);
//        Date next = (lastTime == null) ? new Date() : new Date(lastTime.getTime() + delayInterval);
        Date next = new Date((new Date().getTime() + 10000));
//        Date next = new Date(123,3,1);
//        next.setHours(8);
//        next.setMinutes(30);
        System.out.println("next run: "+next);
		return next;
    }
}
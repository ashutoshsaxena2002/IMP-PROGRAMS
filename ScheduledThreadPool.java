package com.one97.OBCCPanel.practice.raku;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool implements Runnable{

    public static void main(String args[]){
        Integer count=Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(count);
        /*
        * The below statement will execute the task after 10 secs of starting of program and only once
        * */
       // scheduledExecutorService.schedule(new ScheduledThreadPool(),10, TimeUnit.SECONDS);

       /*The Below statement wait initially for 3 secs and then executes task after every 5 secs .It does
       * not wait for task to get complete and executes task at regular interval of 5 secs
       * */
      // scheduledExecutorService.scheduleAtFixedRate(new ScheduledThreadPool(),3,5, TimeUnit.SECONDS);
        /*The Below statement wait initially for 3 secs and then executes task after 5 secs of task completion .
         * It does wait for task to get complete and executes task after 5 secs of task completion
         * */
        scheduledExecutorService.scheduleWithFixedDelay(new ScheduledThreadPool(),3,2, TimeUnit.SECONDS);
    }


    @Override
    public void run(){
        System.out.println("Schedules thread running");
    }
}

package com.one97.OBCCPanel.practice.raku;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool implements Runnable {

    /*Executor services use blocking queue which is thread safe.*/
    /*
    * Single thread executor is same as fixedThreadPool but in this the argument of count is taken as 1
    * i.e we want to create only 1 thread and want all task to be executed by single thread ony.
    * Other tasks will have to wait till the thread is executing the preceding task.
    * This is used when we have to implement tasks sequentially
    * */

    public static void main(String args[]){
        Integer count=Runtime.getRuntime().availableProcessors(); //cores of cpu
        ExecutorService executorService= Executors.newFixedThreadPool(count);
        for(int i=0;i<10;i++){
            executorService.execute(new FixedThreadPool());
        }
    }

    @Override
    public void run() {
        System.out.println("Fixed Thread pool");
    }
}

package com.one97.OBCCPanel.practice.raku;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureInThreadPool implements Callable<String> {

    /*Till the time all tasks assigned to different Threads are not completed
    * No future placeholder will be returned even if the values of some placeholer has been
    * decided after completion of their respective task. Till the time all task assigned to each and every th
    * threads are not completed the main thread remains in bloked state*/
    public static void main(String args[]){
        Integer count=Runtime.getRuntime().availableProcessors();
        ExecutorService executorService= Executors.newFixedThreadPool(count);

        List<Future> allFutures=new LinkedList<>();
        for(int i=0;i<10;i++){
            Future<String> future=executorService.submit(new FutureInThreadPool());
            allFutures.add(future);
        }

        for(Future<String> future:allFutures){
            try {
                System.out.println(future.get());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public String call() throws Exception{
        Thread.sleep(500000);
        String s="Hi"+Math.random();
        return s;
    }
}

package com.one97.OBCCPanel.practice.raku;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool implements Runnable{


    public static void main(String args[]){
        /*Cached thread Pool, it automatically created a new Thread for new task if all created threads are busy and
         destroy those threads which have been idol for more than
        60s secs.*/
        ExecutorService executorService=Executors.newCachedThreadPool();


        for(int i=0;i<50;i++){
            CachedThreadPool t=new CachedThreadPool();
            System.out.println(i);
            executorService.execute(t);
        }
    }

    @Override
    public void run(){
        System.out.println("hi");
    }
}

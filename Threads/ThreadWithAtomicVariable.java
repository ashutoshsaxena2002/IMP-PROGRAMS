package com.one97.OBCCPanel.practice.paypal.Graphs.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWithAtomicVariable {

    private static AtomicInteger counter=new AtomicInteger(0);
    public  void incrementCounterThousandTimes() throws Exception{
       for(int i=1;i<=1000;i++){
           counter.incrementAndGet();
       }
    }


    public  void incrementCounterThreeThousandTimes() throws Exception{
        for(int i=1;i<=3000;i++){
            counter.incrementAndGet();
        }
    }

    public static void main(String [] args) throws InterruptedException {
        ThreadWithAtomicVariable threadWithAtomicVariable =new ThreadWithAtomicVariable();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadWithAtomicVariable.incrementCounterThousandTimes();
                }
                catch (Exception e){

                }
            }
        });


        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadWithAtomicVariable.incrementCounterThreeThousandTimes();
                }
                catch (Exception e){

                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.get());
    }
}

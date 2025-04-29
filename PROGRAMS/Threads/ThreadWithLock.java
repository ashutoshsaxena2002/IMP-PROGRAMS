package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWithLock {

    private static Integer counter=0;
    private final ReentrantLock reentrantLock=new ReentrantLock();
    private final Condition condition= reentrantLock.newCondition();

    public  void printEven() throws Exception{
        while(counter<=10){
            reentrantLock.lock();
            if(counter%2!=0){
                condition.await();
            }
            System.out.println(counter);
            Thread.sleep(500);
            counter++;
            condition.signalAll();
            reentrantLock.unlock();
        }
    }


    public  void printOdd() throws Exception{
        while(counter<=10){
            reentrantLock.lock();
            if(counter%2==0){
                condition.await();
            }
            System.out.println(counter);
            Thread.sleep(2000);
            counter++;
            condition.signalAll();
            reentrantLock.unlock();
        }
    }

    public static void main(String [] args){
        ThreadWithLock threadWithLock =new ThreadWithLock();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadWithLock.printOdd();
                }
                catch (Exception e){

                }
            }
        });


        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadWithLock.printEven();
                }
                catch (Exception e){

                }
            }
        });

        t1.start();
        t2.start();
    }
}

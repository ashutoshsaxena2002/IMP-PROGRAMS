package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.Threads;

class PrintEven implements Runnable{
    private ThreadWithSynchronize threadWithSynchronize;
    PrintEven(ThreadWithSynchronize threadWithSynchronize){
        this.threadWithSynchronize=threadWithSynchronize;
    }

    @Override
    public void run() {
        try{
            threadWithSynchronize.printEven();
        }
        catch (Exception e){

        }
    }
}


class PrintOdd implements Runnable{
    private ThreadWithSynchronize threadWithSynchronize;
    PrintOdd(ThreadWithSynchronize threadWithSynchronize){
        this.threadWithSynchronize=threadWithSynchronize;
    }

    @Override
    public void run() {
        try{
            threadWithSynchronize.printOdd();
        }
        catch (Exception e){

        }
    }
}

public class ThreadWithSynchronize {
    private  Integer counter=0;// This program will work with non-static variable as
    // both thread is using same instance of ThreadWithSynchronize class.
    // If we want to use 2 different instance of ThreadWithSynchronize class for 2 threads then we nedd to use static variable

    //private static  Integer counter=0;
     private static Object lock=new Object();
    // If we are using 2 different instance
    // then we need to use static counter and if we are using static counter then we need to create this lock object as synchronization
    // is on method level so monitoring will be done on 2 different object function so we need to create this static object to make the
    // synchronize monitoring common and we will implement the function as below.

  /*  public  void printEven() throws Exception{
        synchronized (lock) {
            while (counter <= 10) {
                if (counter % 2 != 0) {
                    lock.wait();
                }
                System.out.println(counter);
                Thread.sleep(500);
                counter++;
                lock.notifyAll();
            }
        }
    }


    public  void printOdd() throws Exception{
        synchronized (lock) {
            while (counter <= 10) {
                if (counter % 2 == 0) {
                    lock.wait();
                }
                System.out.println(counter);
                Thread.sleep(2000);
                counter++;
                lock.notifyAll();
            }
        }
    }*/
    public synchronized void printEven() throws Exception{
        while(counter<=10){
            if(counter%2!=0){
                wait();
            }
            System.out.println(counter);
            Thread.sleep(500);
            counter++;
            notifyAll();
        }
    }


    public synchronized void printOdd() throws Exception{
        while(counter<=10){
            if(counter%2==0){
                wait();
            }
            System.out.println(counter);
            Thread.sleep(2000);
            counter++;
            notifyAll();
        }
    }

    public static void main(String [] args){
        ThreadWithSynchronize threadWithSynchronize =new ThreadWithSynchronize();
        Thread t1=new Thread(new PrintOdd(threadWithSynchronize));
        Thread t2=new Thread(new PrintEven(threadWithSynchronize));

        /* using 2 different instance for 2 threads , here we need to use static counter
        ThreadWithSynchronize threadWithSynchronize1 =new ThreadWithSynchronize();
        ThreadWithSynchronize threadWithSynchronize2 =new ThreadWithSynchronize();
        Thread t1=new Thread(new PrintOdd(threadWithSynchronize1));
        Thread t2=new Thread(new PrintEven(threadWithSynchronize2));*/



        t1.start();
        t2.start();
    }

}

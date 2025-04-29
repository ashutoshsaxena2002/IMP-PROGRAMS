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
    private static Integer counter=0;

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
        t1.start();
        t2.start();
    }

}

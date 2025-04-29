package com.one97.OBCCPanel.practice.paypal.Graphs.Threads;




public class ThreadWithSynchronizeAndAnonymousFunction {

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
        ThreadWithSynchronizeAndAnonymousFunction threadWithSynchronizeAndAnonymousFunction =new ThreadWithSynchronizeAndAnonymousFunction();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadWithSynchronizeAndAnonymousFunction.printOdd();
                }
                catch (Exception e){

                }
            }
        });


        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    threadWithSynchronizeAndAnonymousFunction.printEven();
                }
                catch (Exception e){

                }
            }
        });

        t1.start();
        t2.start();
    }

}

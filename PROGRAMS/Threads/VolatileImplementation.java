package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.Threads;



public class VolatileImplementation {
    public static  boolean flag=false;

    public static void setTheFLagTrue() throws Exception{
        Thread.sleep(5000);
        flag=true;
    }

    public static void checkTheFlag(){
        while(!flag){
        }
        System.out.println("NOW THE FLAG VALUE IS:"+flag);
    }
    public static void main(String [] args) throws InterruptedException {

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    setTheFLagTrue();
                }
                catch (Exception e){

                }

            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                checkTheFlag();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}

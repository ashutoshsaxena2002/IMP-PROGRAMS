package com.one97.OBCCPanel.practice.paypal.Graphs.ThreadPolling;

import java.util.concurrent.*;

class CallableThread implements Callable{

    @Override
    public String call() throws Exception {
        System.out.println("CALLABLE THREAD WAITING...!");
        Thread.sleep(5000);
        System.out.println("CALLABLE THREAD WAITING FINISHED...!");
        return "THIS IS CALLABLE THREAD RUNNING...!";
    }
}

public class ExecutorServiceImplementation implements Runnable{
    @Override
    public void run() {
        System.out.println("THIS IS RUNNABLE THREAD RUNNING...");
    }

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ScheduledExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(5);
        ExecutorService cachedThreadPool=Executors.newCachedThreadPool();

        fixedThreadPool.execute(new ExecutorServiceImplementation());
        cachedThreadPool.submit(new ExecutorServiceImplementation());
        scheduledThreadPool.schedule(new ExecutorServiceImplementation(),2,TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(new ExecutorServiceImplementation(),1,1,TimeUnit.SECONDS);
        scheduledThreadPool.scheduleWithFixedDelay(new ExecutorServiceImplementation(),1,1,TimeUnit.SECONDS);

        Future<String> future=scheduledThreadPool.schedule(new CallableThread(),2,TimeUnit.SECONDS);
        System.out.println(future.get());

        fixedThreadPool.shutdownNow();
        cachedThreadPool.shutdownNow();
        scheduledThreadPool.shutdownNow();
    }
}

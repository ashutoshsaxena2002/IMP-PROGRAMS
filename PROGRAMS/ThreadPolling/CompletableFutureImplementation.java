package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.ThreadPolling;


import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class Thread1 implements Callable{

    @Override
    public String call() throws Exception {
        System.out.println("CALLABLE THREAD WAITING...!");
        Thread.sleep(5000);
        System.out.println("CALLABLE THREAD WAITING FINISHED...!");
        return "THIS IS CALLABLE THREAD RUNNING";
    }
}

public class CompletableFutureImplementation {
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture= CompletableFuture.supplyAsync(()->{
            try {
                return new Thread1().call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).orTimeout(6, TimeUnit.SECONDS).exceptionally(s->"THREAD TOOK TOO LONG TO EXECUTE").thenApply(s->s.concat("_BY ASHUTOSH"));

        System.out.println(completableFuture.get());
        System.out.println("THREAD IS EXECUTED");
    }
}

package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.ThreadPolling;


import java.util.concurrent.*;


class Thread1 implements Callable{

    @Override
    public String call() throws Exception {
        System.out.println("CALLABLE THREAD 1 WAITING...!");
        Thread.sleep(2000);
        System.out.println("CALLABLE THREAD 1 WAITING FINISHED...!");
        return "THIS IS CALLABLE THREAD 1 RETURNED";
    }
}

class Thread2 implements Callable{

    @Override
    public String call() throws Exception {
        System.out.println("CALLABLE THREAD 2 WAITING...!");
        Thread.sleep(2000);
        System.out.println("CALLABLE THREAD 2 WAITING FINISHED...!");
        return "THIS IS CALLABLE THREAD 2 RETURNED";
    }
}

class Thread3 implements Runnable{

    @Override
    public void run()  {
        try {
            System.out.println("RUNNABLE THREAD 3 WAITING...!");
            Thread.sleep(2000);
            System.out.println("RUNNABLE THREAD 3 WAITING FINISHED...!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class Thread4 implements Runnable{

    @Override
    public void run()  {
        try {
            System.out.println("RUNNABLE THREAD 4 WAITING...!");
            Thread.sleep(2000);
            System.out.println("RUNNABLE THREAD 4 WAITING FINISHED...!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class Thread5 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("RUNNABLE THREAD 5 WAITING...!");
            Thread.sleep(2000);
            System.out.println("RUNNABLE THREAD 5 WAITING FINISHED...!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

public class CompletableFutureImplementation {
    public static void main(String [] args) throws Exception {

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        CompletableFuture<String> completableFuture1=CompletableFuture.supplyAsync(()->{
            try {
                return new Thread1().call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> completableFuture2=CompletableFuture.supplyAsync(()->{
            try {
                return new Thread2().call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> completableFuture3=CompletableFuture.runAsync(()->{
            try {
               new Thread(new Thread3()).start();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> completableFuture4=CompletableFuture.runAsync(()->{
            try {
                new Thread(new Thread4()).start();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture <Void> completableFuture5=CompletableFuture.runAsync(()->{
            try {
                executorService.execute(new Thread5());
            }
            catch (Exception e){

            }
        });


         System.out.println(completableFuture2.get());

//        CompletableFuture<String> combinedCompletableFuture=completableFuture1.thenCombine(completableFuture2,(s1,s2)->{
//            return s1.concat(s2);
//        });
//
//        CompletableFuture<Void> completableFuture3=combinedCompletableFuture.thenRun((new Thread3()));
//
//        CompletableFuture<Void> completableFuture4=completableFuture3.thenRun((new Thread4()));

//        System.out.println(completableFuture4.join());
//        System.out.println(combinedCompletableFuture.join());

//        CompletableFuture<Void> allOfCompletableFuture=CompletableFuture.allOf(completableFuture3,completableFuture4,completableFuture1,completableFuture2);
//        System.out.println(completableFuture1.join());
//        System.out.println(completableFuture2.join());
//        System.out.println(completableFuture3.join());
//        System.out.println(completableFuture4.join());
//        CompletableFuture<String> completableFuture= CompletableFuture.supplyAsync(()->{
//            try {
//                return new Thread1().call();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        CompletableFuture<Void> completableFuture2=CompletableFuture.runAsync(()->{
//            Thread thread=new Thread(new Thread3());
//            thread.start();
//        });
//
//        CompletableFuture<Void> completableFuture1=completableFuture.thenRun(new Thread(new Thread2()) ).orTimeout(6, TimeUnit.SECONDS);
//        completableFuture1.join();
//        System.out.println(completableFuture.get());
//        System.out.println("THREAD IS EXECUTED");
    }


}

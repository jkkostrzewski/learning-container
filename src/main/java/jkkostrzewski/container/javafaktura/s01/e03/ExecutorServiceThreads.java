package jkkostrzewski.container.javafaktura.s01.e03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ExecutorServiceThreads {

//    public static void main(String[] args) throws InterruptedException {
//        LowestContainer lowestContainer = new LowestContainer(50);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        for (int i = 0; i < 31; i++) {
//            Runnable task = () -> {
//                int rand = new Random().nextInt(100);
//                System.out.println(rand);
//                try {
//                    lowestContainer.compareWithLowest(rand);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Using thread: " + Thread.currentThread().getName());
//            };
//            executorService.submit(task);
//        }
//
//        executorService.shutdown();
//        executorService.awaitTermination(10, SECONDS);
//
////        //Shutting down method recommended by Oracle
////        //https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html
////            executorService.shutdown();
////            try {
////            if (!executorService.awaitTermination(10, SECONDS)) {
////                executorService.shutdownNow();
////            }
////        } catch (InterruptedException e) {
////            executorService.shutdownNow();
////        }
//
//
//
//
//        System.out.println("Lowest number: " + lowestContainer.getLowest());
//    }



//
//    //Future type provides a place for a variable that will be provided in somewhere in future
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        LowestContainer lowestContainer = new LowestContainer(50);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        List<Future<Integer>> futureList = new ArrayList<>();
//
//        //We submit tasks with getting random number to the Executor Service
//        for (int i = 0; i < 31; i++) {
//            Callable<Integer> task = () -> new Random().nextInt(100);
//            Future<Integer> result = executorService.submit(task);
//
//            futureList.add(result);
//        }
//
//        System.out.println("All tasks submitted");
//
//        //Now we compare all the values submitted and get lowest
//        for (Future<Integer> future : futureList) {
//            System.out.println("Lowest atm: " + lowestContainer.compareWithLowest(future.get()));
//        }
//
//        System.out.println("Lowest number: " + lowestContainer.getLowest());
//    }



//
//    //ScheduledFuture starts executing code on another thread after a certain period of time
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ScheduledFuture<String> scheduledFuture = Executors.newSingleThreadScheduledExecutor()
//                .schedule(() -> "Done waiting", 5, SECONDS);
//        System.out.println(scheduledFuture.get());
//    }
//

//
//    private static ExecutorService customExecutorService(AtomicInteger idx) {
//        //Guava ThreadFactoryBuilder or Apache commons BasicThreadFactory provides code like this
//        return new ThreadPoolExecutor(
//                1,              //always at least one thread in a pool is active
//                8,          //maximum of 8 threads active at the same time
//                500, MILLISECONDS,      //remove thread if it's idle for 500 miliseconds
//                new LinkedBlockingDeque<>(),        //new tasks are going into this collection
//                r -> {                      //Thread creation - ThreadFactory interface - overriding newThread method
//                    Thread t = new Thread();
//                    t.setName("Custom-" + idx.incrementAndGet());
//                    return t;
//                }
//        );
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        LowestContainer lowestContainer = new LowestContainer(50);
//        ExecutorService executorService = customExecutorService(new AtomicInteger(0));
//        List<Future<Integer>> futureList = new ArrayList<>();
//
//        for (int i = 0; i < 31; i++) {
//            Future<Integer> future = executorService.submit(() -> new Random().nextInt(100));
//            futureList.add(future);
//        }
//
//        for(Future<Integer> future : futureList) {
//            System.out.println(lowestContainer.compareWithLowest(future.get()));
//        }
//
//        System.out.println("Lowest number: " + lowestContainer.getLowest());
//    }

}

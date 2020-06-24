package jkkostrzewski.container.javafaktura.s01.e03.thread;

import java.util.ArrayList;
import java.util.Collection;

public class MultiThreadHelloWorld {
    /*
    //Debug test
    //Example below creates 3 frames for every method used
    //We only use one "main" thread (not counting jvm threads for garbage collector and so on)
    public static void main(String[] args) {
        method1("test");
    }

    private static void method1(String s) {
        method2(s, 1);
    }

    private static void method2(String s, int i) {
        System.out.println("string= " + s + " int=" + i);
    }
    */

    /*
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        LowestContainer lowestContainer = new LowestContainer(50);

        for (int i = 0; i < 31; i++) {
            Runnable runnable = () -> {
                int rand = new Random().nextInt(100);
                System.out.println(rand);
                try {
                    lowestContainer.compareWithLowest(rand);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Thread thread = new Thread(runnable);
            threadList.add(thread);
            System.out.println("Created new thread: " + thread.getName());
            thread.start();
        }

        for (Thread th : threadList) {
            th.join();
        }

        System.out.println("Lowest number: " + lowestContainer.getLowest());
    }
     */

    /*
    //This one won't work because two threads can execute increment function at the same time
    //and one would increment an old value
    public static void main(String[] args) throws InterruptedException {
        SimpleCounter counter = new SimpleCounter();
        Collection<Thread> threads = new ArrayList<>();
        for (int threadIdx = 0; threadIdx < 20; threadIdx++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100_000 / 20; i++) {
                    counter.increment();
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("The counter value should be at 100_000: " + counter.getCounter());
    }
     */

    //This one works with atomic variable and correctly increment value
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        Collection<Thread> threads = new ArrayList<>();
        for (int threadIdx = 0; threadIdx < 20; threadIdx++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100_000 / 20; i++) {
                    counter.increment();
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("The counter value should be at 100_000: " + counter.total());
    }
}

package jkkostrzewski.container.javafaktura.s01.e03;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int total() {
        return count.get();
    }
}

package jkkostrzewski.container.javafaktura.s01.e03.thread;

public class SimpleCounter {
    private int counter;

    public SimpleCounter() {
        this.counter = 0;
    }

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

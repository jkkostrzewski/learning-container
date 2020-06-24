package jkkostrzewski.container.javafaktura.s01.e03.thread;

public class LowestContainer {
    private int lowest;

    public LowestContainer(int lowest) {
        this.lowest = lowest;
    }

    public int getLowest() {
        return lowest;
    }

    public void setLowest(int lowest) {
        this.lowest = lowest;
    }

    public void compareWithLowest(int number) throws InterruptedException {
        Thread.sleep(200);
        if (number < lowest) {
            lowest = number;
        }
    }
}

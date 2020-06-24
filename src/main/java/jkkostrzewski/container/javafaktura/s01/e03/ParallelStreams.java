package jkkostrzewski.container.javafaktura.s01.e03;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String[] args) {
        //Parallel streams work well if we don't need to keep the order of given objects
        OptionalDouble average = IntStream.range(1, 10).parallel().average();

        average.ifPresent(System.out::println);

        //Here we can see that numbers won't print out in order
        IntStream.range(1, 10).parallel().forEach(System.out::println);
    }
}

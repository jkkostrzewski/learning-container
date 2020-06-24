package jkkostrzewski.container.javafaktura.s01.e02.streams;

import jkkostrzewski.container.javafaktura.s01.Utils;

import java.util.stream.IntStream;

import static jkkostrzewski.container.javafaktura.s01.Utils.newIntStream;
import static jkkostrzewski.container.javafaktura.s01.Utils.printStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        //Primitive values
        newIntStream().forEach(System.out::println);

        Utils.blockBreaker();

        //Values boxed into Integer
        newIntStream().boxed().forEach(System.out::println);

        Utils.blockBreaker();

        IntStream mappedStream = newIntStream().map(i -> i + 1);
        printStream(mappedStream);

        Utils.blockBreaker();

        //Mapping primitive values to objects
        newIntStream().mapToObj(ResidentialAreaHelper::randomArea);
    }
}

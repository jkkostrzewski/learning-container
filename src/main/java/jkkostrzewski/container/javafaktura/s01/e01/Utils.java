package jkkostrzewski.container.javafaktura.s01.e01;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {
    public static String random(Integer value) {
        return value != null ? value.toString() : "No value";
    }

    public static void blockBreaker() {
        System.out.println("\n");
    }

    public static String nullCall() {
        return null;
    }

    public static Integer nullIntCall() {
        return null;
    }

    public static Optional<Integer> optionalCall() {
        return Optional.of(20);
    }

    public static Optional<Integer> emptyCall() {
        return Optional.empty();
    }

    // ? - Question mark in generic type is a Wildcard - represents an unknown type
    public static void printStream(Stream<?> stream) {
        stream.forEach(System.out::println);
    }

    public static void printStream(IntStream stream) {
        stream.forEach(System.out::println);
    }

    public static void printCollection(Collection<?> collection) {
        collection.forEach(System.out::println);
    }

    public static void printMap(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static IntStream newIntStream() {
        return IntStream.of(1, 2, 3, 4);
    }
}

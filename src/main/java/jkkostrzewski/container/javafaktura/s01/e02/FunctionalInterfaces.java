package jkkostrzewski.container.javafaktura.s01.e02;

import jkkostrzewski.container.javafaktura.s01.Utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        //Consumer is a functional interface that takes lambda expression as an assignment argument or method reference
        Consumer<String> consumer = s -> System.out.println(s);
        Consumer<String> consumerAsAMethodReference = System.out::println;

        //Consumer.accept(T t) performs the operation assigned to consumer object with a given argument.
        consumer.accept("Lambda expression");
        consumerAsAMethodReference.accept("Method reference");

        Utils.blockBreaker();

        //Supplier works in a similar way as a consumer with a difference that it doesn't take any arguments
        //and only returns a value
        Supplier<String> supplier = () -> "Supplier string from lambda";
        Random random = new Random();
        Supplier<Integer> supplierAsMethodReference = random::nextInt;

        //Supplier.get() returns the value from a assigned expression
        System.out.println(supplier.get());
        System.out.println(supplierAsMethodReference.get());

        Utils.blockBreaker();

        //Function takes and argument and returns value based on a function assigned
        Function<Integer, String> function = arg -> arg != null ? arg.toString() : "No value";
        Function<Integer, String> functionAsMethodReference = Utils::random;

        System.out.println(function.apply(15));
        System.out.println(function.apply(null));
        System.out.println(functionAsMethodReference.apply(16));
        System.out.println(functionAsMethodReference.apply(null));


        Utils.blockBreaker();

        //BinaryOperator takes two parameters of the same type (that's why we only define BigInteger once) and
        //returns value based on a function assigned
        BinaryOperator<BigInteger> binaryOperator = BigInteger::add;

        System.out.println(binaryOperator.apply(BigInteger.ONE, BigInteger.TWO));

    }
}

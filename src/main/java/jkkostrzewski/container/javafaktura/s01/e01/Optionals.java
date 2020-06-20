package jkkostrzewski.container.javafaktura.s01.e01;

import java.util.List;
import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        //This one will result in NullPointerException
        //Optional<String> noNullableCall = Optional.of(Utils.nullCall());

        //This one will work if function returns null
        Optional<String> nullableCall = Optional.ofNullable(Utils.nullCall());

        //Calling Optional.get() on optional that has a null inside result in NoSuchElementException
        //System.out.println(nullableCall.get());

        //What we do is we use Optional.isPresent()
        if (nullableCall.isPresent()) {
            System.out.println(nullableCall.get());
        }

        //Or functional Optional.ifPresent()
        nullableCall.ifPresent(System.out::println);

        //Or we use Optional.getOrElseThrow to inform user in case of null value
        //System.out.println(nullableCall.orElseThrow());

        //More functional use of Optional
        Utils.optionalCall().ifPresent(System.out::println);

        Utils.blockBreaker();

        //Alternative path if there is no value in optional
        Utils.optionalCall().ifPresentOrElse(
                value -> System.out.println("There was value in optional: " + value),
                () -> System.out.println("There is no value in optional")
        );

        Utils.emptyCall().ifPresentOrElse(
                value -> System.out.println("There was value in optional: " + value),
                () -> System.out.println("There is no value in optional")
        );

        Utils.blockBreaker();

        //Assigning value depending on availability of value in optional
        Integer optionalCall = Utils.optionalCall()
                .map(i -> i + 10)
                .orElse(-1);
        System.out.println(optionalCall);

        Integer emptyCall = Utils.emptyCall()
                                    .map(i -> i + 10)
                                    .orElse(-1);
        System.out.println(emptyCall);

        Utils.blockBreaker();

        //Assigning value only if it fulfills filter
        Integer filteredValue = Utils.optionalCall()
                .filter(i -> i > 20)
                .orElse(-12);
        System.out.println(filteredValue);

        //Chaining optional calls
        Integer chainedValue = Optional.ofNullable(Utils.nullIntCall())
                .or(Utils::emptyCall)
                .or(Utils::optionalCall)
                .map(i -> i + 29)
                .orElse(-1);
        System.out.println(chainedValue);
    }

    //Optional Bad practices
    //Never pass optional as a function argument
    private void function(Optional<Integer> parameter) {

    }

    //Never use optional as fields in class that you want to serialize
    private static class DomainModel {
        Optional<Integer> myField;
    }

    //We should return emptyList instead of Optional
    private Optional<List<Integer>> callList() {
        return Optional.empty();
    }


    //Optional good practices
    //Returning optional from function as a result
    private Optional<Integer> call(Integer parameter) {
        return Optional.ofNullable(parameter);
    }
}

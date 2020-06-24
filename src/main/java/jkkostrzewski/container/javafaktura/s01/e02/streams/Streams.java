package jkkostrzewski.container.javafaktura.s01.e01.streams;

import jkkostrzewski.container.javafaktura.s01.e01.Utils;
import jkkostrzewski.container.javafaktura.s01.e01.streams.model.Block;
import jkkostrzewski.container.javafaktura.s01.e01.streams.model.Floor;
import jkkostrzewski.container.javafaktura.s01.e01.streams.model.Person;
import jkkostrzewski.container.javafaktura.s01.e01.streams.model.Sex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static jkkostrzewski.container.javafaktura.s01.e01.Utils.printStream;
import static jkkostrzewski.container.javafaktura.s01.e01.Utils.printCollection;
import static jkkostrzewski.container.javafaktura.s01.e01.Utils.printMap;

public class Streams {
    public static void main(String[] args) {
        //Many ways to create stream
        Stream<Person> simplePeople = Stream.of(Person.random(), Person.random(), Person.random());
        printStream(simplePeople);

        Utils.blockBreaker();

        Stream<Person> collectionStream = ResidentialAreaHelper.randomPeople(3).stream();
        printStream(collectionStream);

        Utils.blockBreaker();

        Stream<Person> streamBuilder = Stream.<Person>builder().add(Person.random())
                                                               .add(Person.random())
                                                               .add(Person.random())
                                                               .build();
        printStream(streamBuilder);

        Utils.blockBreaker();

        //If we don't specify limit here the stream will generate indefinitely
        Stream<Person> generated = Stream.generate(Person::random).limit(4);
        printStream(generated);

        Utils.blockBreaker();

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //Skipping all the operations that I'm comfortable with


        List<Person> people = ResidentialAreaHelper.randomPeople(10);

        //We can reuse streams
        printStream(
                ResidentialAreaHelper.randomPeopleStream(10)
                .filter(p -> p.getSex() == Sex.MALE)
                .filter(Person::isMarried)
        );

        Utils.blockBreaker();

        //Stream collecting
        List<Person> collected = people.stream()
                .collect(ArrayList::new, List::add, List::addAll);
        printCollection(collected);

        Utils.blockBreaker();

        //Collect joining
        String namesSeparated = people.stream()
                .map(Person::getFullName)
                .collect(Collectors.joining(", "));
        System.out.println(namesSeparated);

        Utils.blockBreaker();

        //Advanced collecting
        Map<Sex, Integer> countBySex = people.stream()
                .map(Person::getSex)
                .collect(HashMap::new,
                        (map, sex) -> map.put(sex, map.getOrDefault(sex, 0) + 1),
                        (map, map2) -> map.forEach(
                                (key, value) -> map2.put(key, map2.getOrDefault(key, 0) + value)
                        ));
        printMap(countBySex);

        Utils.blockBreaker();

        //Same as previous one but easier
        printMap(
                people.stream().collect(groupingBy(Person::getSex, counting()))
        );

        Utils.blockBreaker();

        //Sorting
        printStream(
                people.stream()
                    .sorted((p1, p2) -> p1.getSalary() - p2.getSalary())
        );

        Utils.blockBreaker();

        //Alternatively
        printStream(
                people.stream()
                    .sorted(Comparator.comparing(Person::getSalary))
        );

        Utils.blockBreaker();

        Optional<Person> reducedPerson = people.stream()
                                               .reduce(((person, person2) -> {
                                                   person.setFullName(person.getFullName() + ", " + person2.getFullName());
                                                   return person;
                                               }));
        System.out.println("Reduced person name: " + reducedPerson.get());

        Utils.blockBreaker();

        Person onePersonReduced = people.stream()
                .reduce(Person.random(), ((person, person2) -> {
                    person.setFullName(person.getFullName() + ", " + person2.getFullName());
                    return person;
                }));
        System.out.println("Reduced one person: " + onePersonReduced);

        Utils.blockBreaker();

        Integer salarySum = people.stream().parallel()
                .reduce(0,
                        (integer, person) -> integer + person.getSalary(),
                        (Integer::sum));
        System.out.println(salarySum);

        Utils.blockBreaker();

        ///////////////////////////////////////////////////////////////////////////////////////////////
        List<Block> blocks = ResidentialAreaHelper.randomArea(4).collect(toList());

        //Connecting small streams to one bigger
        Stream<Floor> floorStream = blocks.stream()
                .flatMap(b -> b.getFloors().stream());

        long residentsCount = blocks.stream()
                .flatMap(b -> b.getFloors().stream())
                .flatMap(f -> f.getFlats().stream())
                .mapToLong(f -> f.getResidents().size())
                .sum();
        System.out.println(residentsCount);

        Utils.blockBreaker();

        ///////////////////////////////////////////////////////////////////////////////////////////////
        Optional<Person> minSalary = people.stream().min(Comparator.comparingInt(Person::getSalary));
        System.out.println(minSalary);

        Optional<Person> maxSalary = people.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println(maxSalary);

        Utils.blockBreaker();

        //People that are married
        boolean everyoneMarried = people.stream().allMatch(Person::isMarried);
        System.out.println(everyoneMarried);

        boolean noneMarried = people.stream().noneMatch(Person::isMarried);
        System.out.println(noneMarried);

        boolean someoneMarried = people.stream().anyMatch(Person::isMarried);
        System.out.println(someoneMarried);

        Utils.blockBreaker();

        Optional<Person> firstMarried = people.stream()
                                              .filter(Person::isMarried)
                                              .findFirst();
        System.out.println(firstMarried);
    }
}

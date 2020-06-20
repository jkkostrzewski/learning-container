package jkkostrzewski.container.javafaktura.s01.e01.streams.model;

import java.util.Random;

public class Person {

    private String fullName;
    private boolean married;
    private int salary;
    private Sex sex;

    public static Person random() {
        Person person = new Person();
        person.fullName = Integer.toString(new Random().nextInt());
        person.married = new Random().nextBoolean();
        person.salary = new Random().nextInt(20000);
        person.sex = new Random().nextBoolean() ? Sex.MALE : Sex.FEMALE;
        return person;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", married=" + married +
                ", salary=" + salary +
                ", sex=" + sex +
                '}';
    }
}
package com.pb.shovyrin.hw6;

import java.util.Objects;
import java.util.Random;

public class Dog extends Animal {
    private String walkType;
    private int temperature;

    public Dog(String name, String food, String location) {
        super(name, food, location);
        this.walkType = "гулять по двору";
        this.temperature = new Random().nextInt(6) + 36;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return temperature == dog.temperature && Objects.equals(walkType, dog.walkType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walkType, temperature);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "walkType='" + walkType + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void sleep() {
        System.out.println("Собака по имени " + this.animalName + " спит на мягкой подушке в будке");
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака лает и рычит");
    }

    @Override
    public void eat() {
        System.out.println("Собака кушает " + food + " ей это очень по душе");
    }

    @Override
    public void walk() {
        System.out.println("Животное любит " + walkType);
    }

}

package com.pb.shovyrin.hw6;

import java.util.Objects;
import java.util.Random;

public class Cat extends Animal {
    private String walkType;

    public int getTemperature() {
        return temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return temperature == cat.temperature && Objects.equals(walkType, cat.walkType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), walkType, temperature);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "animalName='" + animalName + '\'' +
                ", food='" + food + '\'' +
                ", location='" + location + '\'' +
                ", walkType='" + walkType + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    private int temperature;

    public Cat(String name, String food, String location) {
        super(name, food, location);
        this.walkType = "гулять по дому";
        this.temperature = new Random().nextInt(6) + 36;
    }

    @Override
    public void sleep() {
        System.out.println("Кот по имени " + this.animalName + " спит на подстилке");
    }

    @Override
    public void makeNoise() {
        System.out.println("Кот мурлыкает и шипит");
    }

    @Override
    public void eat() {
        System.out.println("Кот лениво посмотрел на " + food + " и подумал ладно поем");
    }

    @Override
    public void walk() {
        System.out.println("Животное любит " + walkType);
    }
}

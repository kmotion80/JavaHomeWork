package com.pb.shovyrin.hw6;

import java.util.Objects;
import java.util.Random;

public class Horse extends Animal {
    private String walkType;

    public int getTemperature() {
        return temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Horse horse = (Horse) o;
        return temperature == horse.temperature && Objects.equals(walkType, horse.walkType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), walkType, temperature);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "animalName='" + animalName + '\'' +
                ", food='" + food + '\'' +
                ", location='" + location + '\'' +
                ", walkType='" + walkType + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    private int temperature;

    public Horse(String name, String food, String location) {
        super(name, food, location);
        this.walkType = "гулять по улице";
        this.temperature = new Random().nextInt(6) + 36;
    }

    @Override
    public void sleep() {
        System.out.println("Лошадь по имени " + this.animalName + " спит стоя в стойле");
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь произносит что-то похожее на Иго-го!");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь очень любит " + food + "!");
    }

    @Override
    public void walk() {
        System.out.println("Животное любит " + walkType);
    }
}

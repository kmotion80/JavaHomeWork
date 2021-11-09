package com.pb.shovyrin.hw6;

import java.util.Objects;

public class Animal {
    protected String animalName;
    protected String food;
    protected String location;
    private int temperature;

    public Animal(String name, String food, String location) {
        this.animalName = name;
        this.food = food;
        this.location = location;
        this.temperature = 36;
    }

    public void makeNoise() {
        System.out.println("Животное издает звук");
    }

    public void eat() {
        System.out.println("Животное кушает");
    }

    public void sleep() {
        System.out.println("Ложим животное спать");
    }

    public void walk() {
        System.out.println("Животное любит гулять");
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return temperature == animal.temperature && Objects.equals(animalName, animal.animalName) && Objects.equals(food, animal.food) && Objects.equals(location, animal.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, food, location, temperature);
    }
}

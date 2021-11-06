package com.pb.shovyrin.hw6;

import java.util.Objects;

public class Animal {
    public String animalName;
    public String food;
    public String location;
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
}

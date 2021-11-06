package com.pb.shovyrin.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Animal animal1 = new Cat("Barsik", "кошачий корм", "дом");
        Animal animal2 = new Dog("Busya", "косточки", "будка");
        Animal animal3 = new Horse("Voronoy", "овес", "стойло");
        Animal[] animals = new Animal[]{animal1, animal2, animal3};

        for (Animal animal : animals) {
            animal.sleep();
            animal.makeNoise();
            animal.eat();
            animal.walk();
        }

        Class veterinaryClazz = Class.forName("com.pb.shovyrin.hw6.Veterinarian");
        Constructor constructor = veterinaryClazz.getConstructor(new Class[]{String.class});
        Object obj = constructor.newInstance("Айболит");
        if (obj instanceof Veterinarian) {
            for (Animal animal : animals) {
                ((Veterinarian) obj).treatAnimal(animal);
                ((Veterinarian) obj).getTemparature(animal);
            }
        }

        if(animal1.equals(animal2)){
            System.out.println("Животное 1 похоже на животное 2");
        }else{
            System.out.println("Животное 1 и животное 2 имеют разные типы");
        }

        System.out.println(animal3.toString());
    }
}

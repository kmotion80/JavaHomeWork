package com.pb.shovyrin.hw6;

public class Veterinarian {
    private String vetName;

    public String getVetName() {
        return vetName;
    }

    public Veterinarian(String vetName){
        this.vetName = vetName;
    }

    public void treatAnimal(Animal animal) {
        System.out.println("На прием пришло животное, которое питается: " + animal.food + ". Проживает животное " + animal.location);
    }

    public void getTemparature(Animal animal) {
        int temperature = animal.getTemperature();
        if (temperature > 37) {
            this.getTablet(animal);
        } else {
            System.out.println("Животное по имени " + animal.animalName + " полностью здоровое");
        }
    }

    private void getTablet(Animal animal) {
        System.out.println("Животное по имени " + animal.animalName + " имеет температуру " + animal.getTemperature() + " и получает таблетку");
    }
}

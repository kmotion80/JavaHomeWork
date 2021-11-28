package com.pb.shovyrin.hw10;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int size;
        Scanner in = new Scanner(System.in);

        //Integer
        System.out.println("Массив int элементов, введите его размер: ");
        size = in.nextInt();

        NumBox<Integer> intObj = new NumBox<>(size);
        for (int i = 0; i <= size; i++) {
            Random rand = new Random();
            intObj.add(i, rand.nextInt(100));
        }

        System.out.println("Сгенерированный массив: " + intObj.getArrayString());
        System.out.println("Среднее значение по массиву int: " + intObj.average());
        System.out.println("Сумма всех значений массива int: " + intObj.sum());
        System.out.println("Максимльное число массива int: " + intObj.max());

        int index1 = intObj.get(1);
        int index2 = intObj.get(2);
        System.out.println("Сумма первого и второго элемент массива: " + (index1 + index2));

        //Float
        System.out.println("Массив float элементов, введите его размер: ");
        size = in.nextInt();

        NumBox<Float> floatObj = new NumBox<>(size);

        for (int i = 0; i < size; i++) {
            Random rand = new Random();
            floatObj.add(i, (float) (rand.nextFloat() * 100.0));
        }

        System.out.println("Сгенерированный массив: " + floatObj.getArrayString());
        System.out.println("Среднее значение по массиву float: " + floatObj.average());
        System.out.println("Сумма всех значений массива float: " + floatObj.sum());
        System.out.println("Максимльное число массива float: " + floatObj.max());

        float floatIndex1 = floatObj.get(1);
        float floatIndex2 = floatObj.get(2);
        System.out.println("Сумма первого и второго элемент массива: " + (floatIndex1 + floatIndex2));
    }
}

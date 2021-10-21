package com.pb.shovyrin.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] array = new int[10];
        int allSum = 0;
        int allPositive = 0;

        System.out.println("Заполните массив разными числами");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите " + (i + 1) + " число");
            array[i] = scan.nextInt();
            allSum += array[i];
            allPositive += array[i] > 0 ? 1 : 0;
        }
        System.out.println("Введенный массив:");
        for (int j : array) {
            System.out.print(j + " | ");
        }
        //пузырек
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("\nСумма всех элементов массива = " + allSum);
        System.out.println("Количество положительных чисел в массиве = " + allPositive);

        System.out.println("Отсортированный массив:");
        for (int j : array) {
            System.out.print(j + " | ");
        }
    }
}

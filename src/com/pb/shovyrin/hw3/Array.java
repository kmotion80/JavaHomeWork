package com.pb.shovyrin.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        /*
        2. Создайте класс Array в пакете hw3.
        Программа должна позволить пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
        Вывести на экран введенный массив.
        Подсчитать сумму всех элементов массива и вывести ее на экран.
        Подсчитать и вывести на экран количество положительных элементов.
        Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort)
        Вывести на экран отсортированный массив.
         */
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
        //пузырек
        for(int i = 0; i < array.length; i++ ){
            for(int j = 0; j < array.length; j++){
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Сумма всех элементов массива = " + allSum);
        System.out.println("Количество положительных чисел в массиве = " + allPositive);

        System.out.println("Отсортированный массив:");
        for (int j : array) {
            System.out.print(j + " | ");
        }
    }
}

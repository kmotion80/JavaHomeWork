package com.pb.shovyrin.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int x, y;
        double result = 0.0;
        String sign;
        Boolean noError = true;
        Scanner in = new Scanner(System.in);

        System.out.println("Калькулятор v 1.0");
        System.out.println("Введите число х: ");
        x = in.nextInt();

        System.out.println("Введите число y: ");
        y = in.nextInt();

        System.out.println("Введите знак арифметической операции: ");
        sign = in.next();

        switch (sign) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                if (y != 0) {
                    result = (double)x / y;
                } else {
                    noError = false;    //ставлю значение ошибки и вывод результата не обязателен
                    System.out.println("Деление на 0 запрещено.");
                }
                break;
            default:
                System.out.println("Не поддерживаемая операция");
        }
        //Если нет ошибок выводим результат
        if (noError) {
            System.out.println("Результа вычисления: " + result);
        }
    }
}

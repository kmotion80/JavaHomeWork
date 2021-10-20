package com.pb.shovyrin.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Random randomizer = new Random();
        int rand = randomizer.nextInt(100);
        Scanner scan = new Scanner(System.in);
        int playerNumber;
        int countTry = 0; //количество попыток игрока
        System.out.println("Приветствуем Вас в игре Bingo, я загадал число которое больше 0 но не больше 100, попробуй его угадать. Если надоесть напиши -1 вместо числа");

        while (true) {
            System.out.println("Введите ваше число:");
            playerNumber = scan.nextInt();
            countTry++;
            if (playerNumber == -1) {
                System.out.println("У вас так и не получилось угадать мое число! Вы потратили на это " + countTry + " попыток! Увидемся ещё.");
                break;
            } else if (playerNumber == rand) {
                System.out.println("Поздравляю! Вы угдали мое число " + rand + "! Вам потребовлось всего " + countTry + " попыток!");
                break;
            } else if (playerNumber > rand) {
                System.out.println("Я загадал число меньше твоего!");
            } else if (playerNumber < rand) {
                System.out.println("Я загадал число больше твоего!");
            }else{
                System.out.println("Не понятная ситуация");
                break;
            }
        }
    }
}

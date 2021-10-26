package com.pb.shovyrin.hw4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetter {
    static String firstLetterUpper(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern p = Pattern.compile("([a-zA-Zа-яА-ЯёЁїЇєЄі]+)");
        String str = "";
        StringBuilder sb = new StringBuilder();

        System.out.println("Введите строку для преобразования");
        str = scan.nextLine();
        Matcher m = p.matcher(str);

        while (m.find()) {
            sb.append(firstLetterUpper(m.group()) + " ");
        }
        System.out.println("Ваша преобразованная строка:");
        System.out.println(sb);
    }
}

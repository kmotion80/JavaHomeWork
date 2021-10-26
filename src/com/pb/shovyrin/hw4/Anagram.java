package com.pb.shovyrin.hw4;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstStr = "";
        String secondStr = "";

        System.out.println("Проверим строки на анаграмы для этого введите первую строку");
        firstStr = scan.nextLine();
        System.out.println("Введите вторую строку");
        secondStr = scan.nextLine();

        char[] firstCharArray = clearPointAndLowerCase(firstStr).toCharArray();
        char[] secondCharArray = clearPointAndLowerCase(secondStr).toCharArray();
        //sorting arrays
        Arrays.sort(firstCharArray);
        Arrays.sort(secondCharArray);
        boolean isAnagrams = compareTwoArrays(firstCharArray, secondCharArray);
        if (isAnagrams == true) {
            System.out.println("Две строки являются анаграммами друг друга");
        } else {
            System.out.println("Данные строки не анаграммы");
        }
    }

    private static boolean compareTwoArrays(char[] firstCharArray, char[] secondCharArray) {
        if(firstCharArray.length == 0 || secondCharArray.length == 0){
            return false;
        } else if (firstCharArray.length != secondCharArray.length) {
            return false;
        } else {
            for (int i = 0; i < firstCharArray.length; i++) {
                if (firstCharArray[i] != secondCharArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String clearPointAndLowerCase(String str) {
        return str.replaceAll("[,\\-\\.\\!\\s]", "").toLowerCase(Locale.ROOT);
    }
}

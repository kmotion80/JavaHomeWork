package com.pb.shovyrin.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int x;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите любое число");
        x = in.nextInt();

        if(x > 100 || x < 0){
            System.out.println("Число не входит в промежуток");
        }else if(x >= 51){
            System.out.println("Число входит в промежуток [51 - 100]");
        }else if(x >= 36){
            System.out.println("Число входит в промежуток [36 - 50]");
        }else if(x >= 15){
            System.out.println("Число входит в промежуток [15 - 35]");
        }else if(x >= 0){
            System.out.println("Число входит в промежуток [0 -14]");
        }
    }
}

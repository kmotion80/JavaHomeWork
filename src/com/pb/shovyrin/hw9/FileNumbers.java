package com.pb.shovyrin.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    public static void main(String[] args) {
        Path path = Paths.get("files/numbers.txt");
        //create file
        createNumbersFile(path);
        //read file
        createOddNumbersFile(path);
    }

    public static void createNumbersFile(Path path){
        Random random = new Random();
        int i = 1;
        // write to file
        System.out.println("Записываем данные в файл: ");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            while(i < 100){
                int rand = random.nextInt(100);
                if(i % 10 == 0) {
                    writer.newLine();
                    System.out.println();
                }
                writer.write(rand + " ");
                System.out.print(rand + " ");
                i++;
            }
        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
    }

    public static void createOddNumbersFile(Path path){
        try {
            List<String> lines = Files.readAllLines(path);
            Path oddPath = Paths.get("files/odd-numbers.txt");
            System.out.println("\nЧтение из файла и замена четных на 0");
            try (BufferedWriter writer = Files.newBufferedWriter(oddPath)) {
                for (String line : lines) {
                    Scanner scan = new Scanner(line);
                    scan.useDelimiter(" ");
                    while (scan.hasNext()) {
                        int numb = scan.nextInt();
                        if(numb % 2 == 0){
                            numb = 0;
                        }
                        writer.write(String.valueOf(numb));
                        System.out.print(numb + " ");
                        writer.newLine();
                    }
                    scan.close();
                }
            }catch(Exception ex){
                System.out.println("Error with file write: " + ex);
            }
        }catch(Exception ex){
            System.out.println("Error with file read: " + ex);
        }
    }
}

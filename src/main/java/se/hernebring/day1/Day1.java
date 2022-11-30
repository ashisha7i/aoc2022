package se.hernebring.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/day1sample.txt");
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine())
                System.out.println(scanner.nextLine());

        }
    }
}
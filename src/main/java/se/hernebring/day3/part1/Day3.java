package se.hernebring.day3.part1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day3sample.txt");
        int sum = 0;
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                String current = scanner.nextLine();
                String first = current.substring(0, current.length() / 2);
                String second = current.substring(current.length() / 2);
                for(char c : first.toCharArray()) {
                    if(second.indexOf(c) >= 0) {
                        if(Character.isLowerCase(c))
                            sum += c - 'a' + 1;
                        else
                            sum += c - 'A' + 27;

                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

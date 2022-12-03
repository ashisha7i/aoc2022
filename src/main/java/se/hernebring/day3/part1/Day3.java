package se.hernebring.day3.part1;

import se.hernebring.day3.CharacterUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day3sample.txt");
        int sum = 0;
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext())
                sum += findCommonCharacterValueFromHalf(scanner.nextLine());

        }
        System.out.println(sum);
    }

    private static int findCommonCharacterValueFromHalf(String line) {
        String firstHalf = line.substring(0, line.length() / 2);
        String secondHalf = line.substring(line.length() / 2);
        for(char c : firstHalf.toCharArray()) {
            if(secondHalf.indexOf(c) >= 0)
                return CharacterUtils.getValue(c);

        }
        throw new IllegalStateException();
    }
}

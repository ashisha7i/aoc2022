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
            while(scanner.hasNext()) {
                char c = findCommonCharacterInHalves(scanner.nextLine());
                sum += CharacterUtils.getValue(c);
            }
        }
        System.out.println(sum);
    }

    private static char findCommonCharacterInHalves(String line) {
        String firstHalf = line.substring(0, line.length() / 2);
        String secondHalf = line.substring(line.length() / 2);
        for(char c : firstHalf.toCharArray()) {
            if(secondHalf.indexOf(c) >= 0)
                return c;

        }
        throw new IllegalStateException();
    }
}

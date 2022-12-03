package se.hernebring.day3.part2;

import se.hernebring.day3.CharacterUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day3sample.txt");
        int sum = 0;
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNext())
                sum += findCommonCharacterValueFromThreeLines(
                        sc.nextLine(), sc.nextLine(), sc.nextLine()
                );
        }
        System.out.println(sum);
    }

    private static int findCommonCharacterValueFromThreeLines(String first, String second, String third) {
        for(char c : first.toCharArray()) {
            if(second.indexOf(c) >= 0 && third.indexOf(c) >= 0)
                return CharacterUtils.getValue(c);

        }
        throw new IllegalStateException();
    }
}

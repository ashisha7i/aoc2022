package se.hernebring.day3.part2;

import se.hernebring.day3.CharacterUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day3sample.txt");
        int sum = 0;
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNext()) {
                char c = findCommonCharacterFrom(sc.nextLine(), sc.nextLine(), sc.nextLine());
                sum += CharacterUtils.getValue(c);
            }
        }
        System.out.println(sum);
    }

    private static char findCommonCharacterFrom(String first, String second, String third) {
        for(char c : first.toCharArray()) {
            if(second.indexOf(c) >= 0 && third.indexOf(c) >= 0)
                return c;

        }
        throw new IllegalStateException();
    }
}

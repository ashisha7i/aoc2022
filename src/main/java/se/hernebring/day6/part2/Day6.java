package se.hernebring.day6.part2;

import se.hernebring.day6.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day6sample.txt");
        try(Scanner sc = new Scanner(file)) {
            System.out.println(StringUtils.findUniqueCharacterSequence(sc.nextLine(), 14));
        }
    }
}

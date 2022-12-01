package se.hernebring.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    private static final int[] top3 = new int[3];

    public static void main(String[] args) throws FileNotFoundException {
        final File file = new File("src/main/resources/day1sample.txt");
        int sum = 0;
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                String current = scanner.nextLine();
                if(current.isBlank()) {
                    addToHighScore(sum);
                    sum = 0;
                } else
                    sum += Integer.parseInt(current);

            }
        }
        //Last line is data
        addToHighScore(sum);
        //Part 1:
        System.out.println(top3[0]);
        //Part 2:
        System.out.println(top3[0] + top3[1] + top3[2]);
    }

    private static void addToHighScore(int sum) {
        if(sum > top3[0]) {
            top3[2] = top3[1];
            top3[1] = top3[0];
            top3[0] = sum;
        } else if(sum > top3[1]) {
            top3[2] = top3[1];
            top3[1] = sum;
        } else if(sum > top3[2])
            top3[2] = sum;

    }
}

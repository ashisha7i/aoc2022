package se.hernebring.day4.part2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day4 {
    private static int min1 ,max1 ,min2 , max2;

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day4sample.txt");
        try(Scanner scanner = new Scanner(file)) {
            int counter = 0;
            while(scanner.hasNext()) {
                parseRanges(scanner.nextLine());
                boolean overlaps = doesSmallerRangeTouchLargerRange();
                if(overlaps)
                    counter++;

            }
            System.out.println(counter);
        }
    }

    private static boolean doesSmallerRangeTouchLargerRange() {
        boolean overlaps = false;
        if(max1 - min1 > max2 - min2) {
            for(int i = min2; i <= max2; i++) {
                if(i >= min1 & i <= max1)
                    overlaps = true;
            }
        } else {
            for(int i = min1; i <= max1; i++) {
                if(i >= min2 & i <= max2)
                    overlaps = true;
            }
        }
        return overlaps;
    }

    private static void parseRanges(String pair) {
        String[] ranges = pair.split(",");
        String[] numbers = ranges[0].split("-");
        min1 = Integer.parseInt(numbers[0]);
        max1 = Integer.parseInt(numbers[1]);
        numbers = ranges[1].split("-");
        min2 = Integer.parseInt(numbers[0]);
        max2 = Integer.parseInt(numbers[1]);
    }
}

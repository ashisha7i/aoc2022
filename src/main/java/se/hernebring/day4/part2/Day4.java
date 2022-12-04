package se.hernebring.day4.part2;

import se.hernebring.day4.RangePair;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day4sample.txt");
        int counter = 0;
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                RangePair rp = RangePair.parseRanges(scanner.nextLine());
                boolean overlaps = doesSmallerRangeTouchLargerRange(rp);
                if(overlaps)
                    counter++;

            }
        }
        System.out.println(counter);
    }

    private static boolean doesSmallerRangeTouchLargerRange(RangePair rp) {
        return rp.leftMin() <= rp.rightMax() && rp.leftMax() >= rp.rightMin();
    }
}

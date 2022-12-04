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
        boolean overlaps = false;
        if(rp.leftLength() > rp.rightLength()) {
            for(int i = rp.rightMin(); i <= rp.rightMax(); i++) {
                if(i >= rp.leftMin() & i <= rp.leftMax())
                    overlaps = true;

            }
        } else {
            for(int i = rp.leftMin(); i <= rp.leftMax(); i++) {
                if(i >= rp.rightMin() & i <= rp.rightMax())
                    overlaps = true;

            }
        }
        return overlaps;
    }
}

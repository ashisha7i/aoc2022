package se.hernebring.day4.part1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import se.hernebring.day4.RangePair;

public class Day4 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day4samplePart1.txt");
        int counter = 0;
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                RangePair rp = RangePair.parseRanges(scanner.nextLine());
                boolean inside = isSmallerRangeInsideLargerRange(rp);
                if(inside)
                    counter++;

            }
        }
        System.out.println(counter);
    }

    private static boolean isSmallerRangeInsideLargerRange(RangePair rp) {
        boolean inside = true;
        if(rp.leftLength() > rp.rightLength()) {
            for(int i = rp.rightMin(); i <= rp.rightMax(); i++) {
                if(i < rp.leftMin() | i > rp.leftMax())
                    inside = false;

            }
        } else {
            for(int i = rp.leftMin(); i <= rp.leftMax(); i++) {
                if(i < rp.rightMin() | i > rp.rightMax())
                    inside = false;

            }
        }
        return inside;
    }
}

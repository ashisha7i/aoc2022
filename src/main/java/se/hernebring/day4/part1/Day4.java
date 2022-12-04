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
        return (rp.leftMin() >= rp.rightMin() && rp.leftMax()<= rp.rightMax()) ||
                (rp.rightMin() >= rp.leftMin() && rp.rightMax() <= rp.leftMax());
    }
}

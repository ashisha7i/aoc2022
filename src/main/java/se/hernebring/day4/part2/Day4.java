package se.hernebring.day4.part2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day4sample.txt");
        try(Scanner scanner = new Scanner(file)) {
            int counter = 0;
            while(scanner.hasNext()) {
                String pair = scanner.nextLine();
                String[] ranges = pair.split(",");
                String[] numbers = ranges[0].split("-");
                int min1 = Integer.parseInt(numbers[0]);
                int max1 = Integer.parseInt(numbers[1]);
                int length1 =  max1 - min1;
                numbers = ranges[1].split("-");
                int min2 = Integer.parseInt(numbers[0]);
                int max2 = Integer.parseInt(numbers[1]);
                int length2 = max2 - min2;
                boolean overlaps = false;
                if(length1 > length2) {
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
                if(overlaps)
                    counter++;

            }
            System.out.println(counter);
        }
    }
}

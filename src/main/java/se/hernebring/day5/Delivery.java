package se.hernebring.day5;

import java.util.Scanner;

public record Delivery(int number, int fromIndex, int toIndex) {

    public static Delivery parse(String action) {
        int number, fromIndex, toIndex;
        try(Scanner lineScanner = new Scanner(action)) {
            lineScanner.next();
            number = lineScanner.nextInt();
            lineScanner.next();
            fromIndex = lineScanner.nextInt() - 1;
            lineScanner.next();
            toIndex = lineScanner.nextInt() - 1;
        }
        return new Delivery(number, fromIndex, toIndex);
    }
}

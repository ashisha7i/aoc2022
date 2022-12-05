package se.hernebring.day5.part2;

import se.hernebring.day5.Delivery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static se.hernebring.day5.Day5.*;

public class Day5 {
    private static List<String> instructions;
    public static void main(String[] args) throws IOException {
        List<String> crates = createCratesAndInstructions();
        Stack<Character>[] stacks = createStacks(crates);
        performInstructions(stacks);
        printResult(stacks);
    }

    private static List<String> createCratesAndInstructions() throws FileNotFoundException {
        File file = new File("src/main/resources/day5samplePart2.txt");
        List<String> crates = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            instructions = new ArrayList<>();
            String latest;
            do {
                latest = scanner.nextLine();
                crates.add(latest);
            } while(latest.indexOf(']') >= 0);
            scanner.nextLine();
            while(scanner.hasNext())
                instructions.add(scanner.nextLine());

        }
        return crates;
    }
    private static void performInstructions(Stack<Character>[] stacks) {
        for(String action : instructions) {
            Delivery d = Delivery.parse(action);

            int tempIndex;
            if(d.fromIndex() != 0 & d.toIndex() != 0)
                tempIndex = 0;
            else if(d.fromIndex() != 1 & d.toIndex() != 1)
                tempIndex = 1;
            else
                tempIndex = 2;

            moveBoxes(new Delivery(d.number(), d.fromIndex(), tempIndex), stacks);
            moveBoxes(new Delivery(d.number(), tempIndex, d.toIndex()), stacks);
        }
    }
}

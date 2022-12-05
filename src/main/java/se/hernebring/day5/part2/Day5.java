package se.hernebring.day5.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static se.hernebring.day5.Day5.createStacks;
import static se.hernebring.day5.Day5.printResult;

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
            while(scanner.hasNext()) {
                instructions.add(scanner.nextLine());
            }
        }
        return crates;
    }
    private static void performInstructions(Stack<Character>[] stacks) {
        for(String action : instructions) {
            Scanner lineScanner = new Scanner(action);
            lineScanner.next();
            int pops = lineScanner.nextInt();
            lineScanner.next();
            int fromIndex = lineScanner.nextInt() - 1;
            lineScanner.next();
            int toIndex = lineScanner.nextInt() - 1;
            int tempIndex;
            if(fromIndex != 0 & toIndex != 0)
                tempIndex = 0;
            else if(fromIndex != 1 & toIndex != 1)
                tempIndex = 1;
            else
                tempIndex = 2;

            List<Character> boxes = new ArrayList<>();
            for(int i = 0; i < pops; i++)
                boxes.add(stacks[fromIndex].pop());

            for(Character b : boxes)
                stacks[tempIndex].push(b);

            boxes = new ArrayList<>();
            for(int i = 0; i < pops; i++)
                boxes.add(stacks[tempIndex].pop());

            for(Character b : boxes)
                stacks[toIndex].push(b);

        }
    }
}

package se.hernebring.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {

    private static List<String> instructions;

    public static void main(String[] args) throws IOException {
        List<String> crates = createCratesAndInstructions();
        Stack<Character>[] stacks = createStacks(crates);
        performInstructions(stacks);
        printResult(stacks);
    }

    private static List<String> createCratesAndInstructions() throws FileNotFoundException {
        File file = new File("src/main/resources/day5sample.txt");
        List<String> crates = new ArrayList<>();
        instructions = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
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

    public static Stack<Character>[] createStacks(List<String> crates) {
        String indexes = crates.remove(crates.size() - 1).trim();
        int largestIndex = Character.getNumericValue(indexes.charAt(indexes.length() - 1));
        Stack<Character>[] stacks = new Stack[largestIndex];
        for(int s = 0; s < stacks.length; s++)
            stacks[s] = new Stack<>();

        for(int i = crates.size() - 1; i >= 0; i--) {
            String c = crates.get(i);
            for(int j = 1, s = 0; s < largestIndex && j < c.length(); j += 4, s++) {
                char box = c.charAt(j);
                if(box != ' ')
                    stacks[s].push(box);
                
            }
        }
        return stacks;
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
            List<Character> boxes = new ArrayList<>();
            for(int i = 0; i < pops; i++)
                boxes.add(stacks[fromIndex].pop());

            for(Character b : boxes)
                stacks[toIndex].push(b);

        }
    }

    public static void printResult(Stack<Character>[] stacks) {
        for(Stack<Character> s : stacks)
            System.out.print(s.peek());

        System.out.println();
    }
}

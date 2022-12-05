package se.hernebring.day5.part2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day5samplePart2.txt");

        try(Scanner scanner = new Scanner(file)) {
            List<String> crates = new ArrayList<>();
            List<String> instructions = new ArrayList<>();
            String latest;
            do {
                latest = scanner.nextLine();
                crates.add(latest);
            } while(latest.indexOf(']') >= 0);
            while(scanner.hasNext()) {
                instructions.add(scanner.nextLine());
            }
            String indexes = crates.remove(crates.size() - 1).trim();
            int largestIndex = Character.getNumericValue(indexes.charAt(indexes.length() - 1));
            Stack<Character>[] stacks = new Stack[largestIndex];
            for(int s = 0; s < stacks.length; s++) {
                stacks[s] = new Stack<>();
            }
            for(int i = crates.size() - 1; i >= 0; i--) {
                String c = crates.get(i);
                for(int j = 1, s = 0; s < largestIndex && j < c.length(); j += 4, s++) {
                    char box = c.charAt(j);
                    if(box != ' ') {
                        stacks[s].push(box);
                    }
                }
            }
            for(String action : instructions) {
                Scanner lineScanner = new Scanner(action);
                while(lineScanner.hasNext()) {
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
                    for(int i = 0; i < pops; i++) {
                        boxes.add(stacks[fromIndex].pop());
                    }
                    for(Character b : boxes) {
                        stacks[tempIndex].push(b);
                    }
                    boxes = new ArrayList<>();
                    for(int i = 0; i < pops; i++) {
                        boxes.add(stacks[tempIndex].pop());
                    }
                    for(Character b : boxes) {
                        stacks[toIndex].push(b);
                    }
                }
            }
            for(Stack<Character> s : stacks) {
                System.out.print(s.peek());
            }
            System.out.println();
        }

// ALTERNATIVE FOR FUNCTIONAL STRING MANIPULATION
//        String.join(",", readAllLines(file.toPath()));
    }
}

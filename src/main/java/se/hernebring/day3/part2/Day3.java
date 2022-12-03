package se.hernebring.day3.part2;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.nio.file.Files.readAllLines;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day3.txt");
        int sum = 0;
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                String first = scanner.nextLine();
                String second = scanner.nextLine();
                String third = scanner.nextLine();
                Set<Character> common = new HashSet<>();
                for(char c : first.toCharArray()) {
                    if(second.indexOf(c) >= 0) {
                        common.add(c);
                    }
                }
                var it = common.iterator();
                while(it.hasNext()) {
                    var ch = it.next();
                    if(third.indexOf(ch) >= 0) {
                        if(Character.isLowerCase(ch)) {
                            sum += ch - 'a' + 1;
                        } else {
                            sum += ch - 'A' + 27;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

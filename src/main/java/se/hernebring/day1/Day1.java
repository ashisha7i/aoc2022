package se.hernebring.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Day1 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day1sample.txt");
        List<String> lines = readAllLines(file.toPath());
        for(String l : lines)
            System.out.println(l);

// ALTERNATIVE
//        try(Scanner scanner = new Scanner(file)) {
//            while(scanner.hasNext())
//                System.out.println(scanner.nextLine());
//
//        }
    }
}
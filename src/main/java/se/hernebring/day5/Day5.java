package se.hernebring.day5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Day5 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day5sample.txt");
        List<String> lines = readAllLines(file.toPath());
        for(String l : lines)
            System.out.println(l);

// ALTERNATIVE USING SCANNER
//        try(Scanner scanner = new Scanner(file)) {
//            while(scanner.hasNext())
//                System.out.println(scanner.nextLine());
//
//        }

// ALTERNATIVE FOR FUNCTIONAL STRING MANIPULATION
//        String.join(",", readAllLines(file.toPath()));
    }
}

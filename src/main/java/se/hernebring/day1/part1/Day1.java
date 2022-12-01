package se.hernebring.day1.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

public class Day1 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day1sample.txt");
        List<String> lines = readAllLines(file.toPath());
        int max = 0, current = 0;
        for(String l : lines) {
            if(l.isBlank()) {
                if(current > max)
                    max = current;

                current = 0;
            } else
                current += Integer.parseInt(l);

        }
        System.out.println(max);
    }
}
package se.hernebring.day1.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

public class Day1 {

    private static int max = 0, current = 0;

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day1sample.txt");
        List<String> lines = readAllLines(file.toPath());
        for(String l : lines) {
            if(l.isBlank()) {
                addToHighScore();
                current = 0;
            } else
                current += Integer.parseInt(l);

        }
        addToHighScore();
        System.out.println(max);
    }

    private static void addToHighScore() {
        if(current > max)
            max = current;

    }
}
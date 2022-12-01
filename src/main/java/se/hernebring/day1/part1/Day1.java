package se.hernebring.day1.part1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Day1 {

    private static int max = 0;

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day1sample.txt");
        List<String> lines = readAllLines(file.toPath());
        int current = 0;
        for(String l : lines) {
            if(l.isBlank()) {
                addToHighScore(current);
                current = 0;
            } else
                current += Integer.parseInt(l);

        }
        addToHighScore(current);
        System.out.println(max);
    }

    private static void addToHighScore(int current) {
        if(current > max)
            max = current;

    }
}
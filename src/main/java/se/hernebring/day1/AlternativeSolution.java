package se.hernebring.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class AlternativeSolution {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day1sample.txt");
        String commaSeparated = String.join(",", Files.readAllLines(path));
        var calories = Arrays.stream(commaSeparated.split(",,"))
                .map(e -> Arrays.stream(e.split(",")).mapToInt(Integer::parseInt).sum())
                .sorted(Comparator.reverseOrder()).toList();
        //Part 1:
        System.out.println(calories.get(0));
        //Part 2:
        System.out.println(calories.get(0) + calories.get(1) + calories.get(2));
    }
}

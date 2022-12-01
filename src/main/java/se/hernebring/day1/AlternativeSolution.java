package se.hernebring.day1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

import static java.nio.file.Files.readAllLines;

public class AlternativeSolution {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day1sample.txt");
        var elves = Arrays.stream(String.join(",", readAllLines(path)).split(",,"))
                .map(f -> Arrays.stream(f.split(",")).mapToInt(Integer::parseInt).sum())
                .sorted(Comparator.reverseOrder()).toList();

        //Part 1:
        System.out.println(elves.get(0));
        //Part 2:
        System.out.println(elves.get(0) + elves.get(1) + elves.get(2));
    }
}

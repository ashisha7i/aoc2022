package se.hernebring.day8.part1;

import se.hernebring.day8.Grid;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Day8 {
    public static void main(String[] args) throws IOException {
        List<String> lines = readAllLines(Path.of("src/main/resources/day8sample.txt"));
        Grid grid = new Grid(lines);
        System.out.println(grid.countVisibleTrees());
    }
}

package se.hernebring.day1.part2;

import se.hernebring.day1.Calories;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Day1 {

    public static void main(String[] args) throws IOException {
        Calories c = new Calories();
        c.count(new File("src/main/resources/day1sample.txt"));
        System.out.println(c.getTopThreeSum());
    }

}
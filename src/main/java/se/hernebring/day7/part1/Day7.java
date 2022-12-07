package se.hernebring.day7.part1;

import se.hernebring.day7.DepthFirstSearch;
import se.hernebring.day7.Directory;
import se.hernebring.day7.FileSystem;

import java.io.IOException;

import static java.nio.file.Files.readAllLines;

public class Day7 {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = new FileSystem();
        fileSystem.execute();
        printSumOfDirectoriesAtMost100k(fileSystem);
    }

    public static void printSumOfDirectoriesAtMost100k(FileSystem fileSystem) {
        fileSystem.goToRoot();
        int sum = DepthFirstSearch.addWhenAtMost100k(fileSystem.getCurrent());
        System.out.println(sum);
    }
}

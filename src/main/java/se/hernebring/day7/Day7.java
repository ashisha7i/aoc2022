package se.hernebring.day7;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.readAllLines;
import static se.hernebring.day7.part2.Day7.createFileSystem;

public class Day7 {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = createFileSystem();
        fileSystem.printSumOfDirectoriesAtMost100k();
    }
}

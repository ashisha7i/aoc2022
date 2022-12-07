package se.hernebring.day7.part2;

import org.junit.jupiter.api.Assertions;
import se.hernebring.day7.DepthFirstSearch;
import se.hernebring.day7.Directory;
import se.hernebring.day7.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7 {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = new FileSystem();
        fileSystem.execute();
        printSmallestDirectoryAboveThreshold(fileSystem);
    }

    public static void printSmallestDirectoryAboveThreshold(FileSystem fileSystem) {
        int totalSpaceAvailable = 70_000_000;
        int minimumSpaceNeeded = 30_000_000;
        fileSystem.goToRoot();
        Directory directory = fileSystem.getCurrent();
        int rootSize = directory.getSize();
        int unusedSpace = totalSpaceAvailable - rootSize;
        Assertions.assertTrue(unusedSpace < minimumSpaceNeeded);
        List<Integer> above = new ArrayList<>();
        DepthFirstSearch.find(directory, above, minimumSpaceNeeded - unusedSpace);
        Collections.sort(above);
        System.out.println(above.get(0));
    }
}

package se.hernebring.day7;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystem {

    private Directory directory = new Directory();

    public void goToRoot() {
        while(directory.getParent() != null)
            directory = directory.getParent();

    }
    public void goToParent() {
        directory = directory.getParent();
    }

    public void goToChild(String child) {
        directory = directory.getChild(child);
    }

    public void add(String local) {
        if(local.charAt(0) != 'd') {
            String[] file = local.split(" ");
            directory.addFile(file[1], Integer.parseInt(file[0]));
        } else {
            if(local.charAt(local.length() - 1) == ',')
                local = local.substring(0, local.length() - 1);

            Directory child = new Directory(local.substring(4));
            child.addParent(directory);
            directory.addChild(child);
        }
    }

    public void printAll() {
        System.out.println("Directory{name='/'" + System.lineSeparator() + "files=");
        goToRoot();
        List<File> files = directory.getFiles();
        Collections.sort(files);
        System.out.println(files);
        List<Directory> directories = directory.getChildren();
        Collections.sort(directories);
        System.out.println(directories);
        System.out.println("}");
    }

    public void printSumOfDirectoriesAtMost100k() {
        goToRoot();
        int sum = DivideAndConquer.addWhenAtMost100k(directory);
        System.out.println(sum);
    }

    public void printSmallestDirectoryAboveThreshold() {
        int totalSpaceAvailable = 70_000_000;
        int minimumSpaceNeeded = 30_000_000;
        goToRoot();
        int rootSize = directory.getSize();
        int unusedSpace = totalSpaceAvailable - rootSize;
        Assertions.assertTrue(unusedSpace < minimumSpaceNeeded);
        List<Integer> above = new ArrayList<>();
        DivideAndConquer.find(directory, above, minimumSpaceNeeded - unusedSpace);
        Collections.sort(above);
        System.out.println(above.get(0));
    }
}

package se.hernebring.day7;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.readAllLines;

public class Day7 {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = createFileSystem();
        fileSystem.printSumOfDirectoriesAtMost100k();
    }

    public static FileSystem createFileSystem() throws IOException {
        File file = new File("src/main/resources/day7sample.txt");
        String input = String.join(",", readAllLines(file.toPath()));
        FileSystem fileSystem = new FileSystem();
        String[] commands = input.split("\\$ ");
        for(String c : commands) {
            if(!c.isBlank()) {
                if(c.charAt(0) == 'c') {
                    if(c.charAt(3) == '/') {
                        fileSystem.goToRoot();
                    } else if(c.charAt(3) == '.') {
                        fileSystem.goToParent();
                    } else {
                        fileSystem.goToChild(c.substring(3, c.length() - 1));
                    }
                } else {
                    String[] localFiles = c.split(",");
                    for(String local : localFiles) {
                        if(!local.equals("ls"))
                            fileSystem.add(local);
                    }
                }
            }
        }
        return fileSystem;
    }
}

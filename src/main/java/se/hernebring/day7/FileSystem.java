package se.hernebring.day7;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.readAllLines;

public class FileSystem {

    private final String[] commands;
    private Directory directory = new Directory();

    public FileSystem() throws IOException {
        String input = String.join(",",
                readAllLines(Path.of("src/main/resources/day7sample.txt")));
        commands = input.split("\\$ ");
    }

    public void execute() {
        for(String c : commands) {
            if(!c.isBlank()) {
                if(c.charAt(0) == 'c')
                    cd(c);
                else
                    ls(c);

            }
        }
    }

    private void cd(String command) {
        if(command.charAt(3) == '/')
            goToRoot();
        else if(command.charAt(3) == '.')
            goToParent();
        else
            goToChild(command.substring(3, command.length() - 1));

    }

    private void ls(String command) {
        String[] localFiles = command.split(",");
        for(String local : localFiles) {
            if(!local.equals("ls"))
                add(local);

        }
    }

    public void goToRoot() {
        while(directory.getParent() != null)
            goToParent();

    }
    public void goToParent() {
        directory = directory.getParent();
    }

    public void goToChild(String child) {
        directory = directory.getChild(child);
    }

    public void add(String local) {
        if(local.charAt(0) == 'd') {
            Directory child = new Directory(local.substring(4));
            child.addParent(directory);
            directory.addChild(child);
        } else {
            String[] file = local.split(" ");
            directory.addFile(file[1], Integer.parseInt(file[0]));
        }
    }

    public Directory getCurrent() {
        return directory;
    }
}

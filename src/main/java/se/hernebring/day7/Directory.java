package se.hernebring.day7;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final String name;
    private final List<File> files = new ArrayList<>();
    private final List<Directory> children = new ArrayList<>();

    private Directory parent = null;

    public Directory(String name) {
        this.name = name;
    }

    public Directory() {
        this("");
    }

    public void addFile(String name, int size) {
        files.add(new File(name, size));
    }

    public void addChild(Directory directory) {
        children.add(directory);
    }

    public void addParent(Directory directory) {
        parent = directory;
    }

    public Directory getChild(String name) {
        for(Directory child : children) {
            if(child.getName().equals(name))
                return child;

        }
        throw new IllegalStateException();
    }

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    public List<Directory> getChildren() {
        return children;
    }

    public int getSize() {
        int sum = 0;
        for(File f : files) {
            sum += f.size();
        }
        for(Directory d : children) {
            sum += d.getSize();
        }
        return sum;
    }
}

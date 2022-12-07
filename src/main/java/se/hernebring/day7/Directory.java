package se.hernebring.day7;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Comparable<Directory> {

    private final String name;
    private List<File> files = new ArrayList<>();
    private List<Directory> children = new ArrayList<>();

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

    public List<File> getFiles() {
        return files;
    }

    @Override
    public int compareTo(Directory o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' + System.lineSeparator() +
                "files=" + files + System.lineSeparator() +
                "children=" + children +
                '}';
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

    public void removeChild(Directory child) {
        children.remove(child);
    }
}

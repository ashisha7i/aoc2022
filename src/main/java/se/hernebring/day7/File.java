package se.hernebring.day7;

public record File(String name, int size) implements Comparable<File> {
    @Override
    public int compareTo(File o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}

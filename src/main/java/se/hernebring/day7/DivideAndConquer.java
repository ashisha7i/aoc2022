package se.hernebring.day7;

import java.util.List;

public class DivideAndConquer {
    public static int addWhenAtMost100k(Directory directory) {
        int sum = 0;
        int dirSize = directory.getSize();
        if(dirSize <= 100_000) {
            sum += dirSize;
        }
        List<Directory> children = directory.getChildren();
        if(children.size() < 1) {
            return sum;
        }
        for(Directory d : children) {
            sum += addWhenAtMost100k(d);
        }
        return sum;
    }

    public static void find(Directory current, List<Integer> above, int threshold) {
        int currentSize = current.getSize();
        if(currentSize >= threshold) {
            above.add(currentSize);
        }
        List<Directory> children = current.getChildren();
        if(children.size() < 1) {
            return;
        }
        for(Directory d : children) {
            find(d, above, threshold);
        }
    }
}

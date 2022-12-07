package se.hernebring.day7;

import java.util.List;

public class DepthFirstSearch {
    public static int addWhenAtMost100k(Directory directory) {
        int sum = 0;
        int dirSize = directory.getSize();
        if(dirSize <= 100_000)
            sum += dirSize;

        for(Directory d : directory.getChildren())
            sum += addWhenAtMost100k(d);

        return sum;
    }

    public static void find(Directory current, List<Integer> above, int threshold) {
        int currentSize = current.getSize();
        if(currentSize >= threshold)
            above.add(currentSize);
        else
            return;

        for(Directory d : current.getChildren())
            find(d, above, threshold);

    }
}

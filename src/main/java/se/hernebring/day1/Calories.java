package se.hernebring.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Calories {

    private int max1 = 0, max2 = 0, max3 = 0;

    public void count(File file) throws IOException {
        List<String> lines = readAllLines(file.toPath());
        int current = 0;
        for(String l : lines) {
            if(l.isBlank()) {
                addToHighScore(current);
                current = 0;
            } else
                current += Integer.parseInt(l);

        }
        addToHighScore(current);
    }

    private void addToHighScore(int current) {
        if(current > max1) {
            max3 = max2;
            max2 = max1;
            max1 = current;
        } else if(current > max2) {
            max3 = max2;
            max2 = current;
        } else if(current > max3) {
            max3 = current;
        }
    }

    public int getMax() {
        return max1;
    }

    public int getTopThreeSum() {
        return max1 + max2 + max3;
    }
}

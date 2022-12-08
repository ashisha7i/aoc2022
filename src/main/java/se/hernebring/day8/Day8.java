package se.hernebring.day8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import static java.nio.file.Files.readAllLines;

public class Day8 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day8sample.txt");
        List<String> lines = readAllLines(file.toPath());
        int yMax = lines.size();
        int[][] grid = new int[yMax][];
        int xMax = lines.get(0).trim().length();
        Arrays.setAll(grid, row -> new int[xMax]);
        for(int y = 0; y < yMax; y++) {
            String current = lines.get(y);
            for(int x = 0; x < xMax; x++)
                grid[y][x] = Character.getNumericValue(current.charAt(x));

        }
        int counter = 0;
        for(int y = 0; y < yMax; y++) {
            for(int x = 0; x < xMax; x++) {
                if(y == 0 | y == yMax - 1 || x == 0 | x == xMax - 1)
                    counter++;
                else {
                    boolean visible = true;
                    for(int j = y + 1; j < yMax; j++) {
                        if(grid[j][x] >= grid[y][x]) {
                            visible = false;
                            break;
                        }
                    }
                    if(!visible) {
                        visible = true;
                        for(int j = 0; j < y; j++) {
                            if(grid[j][x] >= grid[y][x]) {
                                visible = false;
                                break;
                            }
                        }
                    }
                    if(!visible) {
                        visible = true;
                        for(int i = x + 1; i < xMax; i++) {
                            if(grid[y][i] >= grid[y][x]) {
                                visible = false;
                                break;
                            }
                        }
                    }
                    if(!visible) {
                        visible = true;
                        for(int i = 0; i < x; i++) {
                            if(grid[y][i] >= grid[y][x]) {
                                visible = false;
                                break;
                            }
                        }
                    }
                    if(visible)
                        counter++;
                }
            }
        }
        System.out.println(counter);
    }
}

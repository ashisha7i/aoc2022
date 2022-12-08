package se.hernebring.day8.part2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
        int max = 0;
        for(int y = 0; y < yMax; y++) {
            for(int x = 0; x < xMax; x++) {
                int visible = 0;
                if(y != 0 & y != yMax - 1 & x != 0 & x != xMax - 1) {
                    for(int j = y + 1; j < yMax; j++) {
                        visible++;
                        if(grid[j][x] >= grid[y][x]) {
                            break;
                        }
                    }
                    if(visible != 0) {
                        int counter = 0;
                        for(int j = y - 1; j >= 0; j--) {
                            counter++;
                            if(grid[j][x] >= grid[y][x]) {
                                break;
                            }
                        }
                        visible *= counter;
                    }
                    if(visible != 0) {
                        int counter = 0;
                        for(int i = x + 1; i < xMax; i++) {
                            counter++;
                            if(grid[y][i] >= grid[y][x]) {
                                break;
                            }
                        }
                        visible *= counter;
                    }
                    if(visible != 0) {
                        int counter = 0;
                        for(int i = x - 1; i >= 0; i--) {
                            counter++;
                            if(grid[y][i] >= grid[y][x]) {
                                break;
                            }
                        }
                        visible *= counter;
                    }
                }
                if(visible > max) {
                    max = visible;
                }
            }
        }
        System.out.println(max);
    }
}

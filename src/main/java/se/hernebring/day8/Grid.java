package se.hernebring.day8;

import java.util.Arrays;
import java.util.List;

public class Grid {
    private final int[][] grid;
    private int yMax, xMax;

    public Grid(List<String> lines) {
        grid = createGrid(lines);
    }

    private int[][] createGrid(List<String> lines) {
        yMax = lines.size();
        int[][] grid = new int[yMax][];
        xMax = lines.get(0).trim().length();
        Arrays.setAll(grid, row -> new int[xMax]);
        for(int y = 0; y < yMax; y++) {
            String current = lines.get(y);
            for(int x = 0; x < xMax; x++)
                grid[y][x] = Character.getNumericValue(current.charAt(x));

        }
        return grid;
    }

    public int countVisibleTrees() {
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
        return counter;
    }

    public int findBestSpot() {
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
        return max;
    }
}

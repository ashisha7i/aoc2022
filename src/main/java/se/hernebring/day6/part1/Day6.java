package se.hernebring.day6.part1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day6sample.txt");
        String line;
        try(Scanner scanner = new Scanner(file)) {
            line = scanner.nextLine();
        }
        int counter = 0;
        boolean differentFour = false;
        while(!differentFour) {
            counter++;
            if(counter >= 4) {
                differentFour = true;
                for(int i = counter - 4; differentFour && i < counter + 1; i++) {
                    for(int j = i + 1; j < counter; j++)
                        if(line.charAt(i) == line.charAt(j)) {
                            differentFour = false;
                            break;
                        }
                }
            }
        }
        System.out.println(counter);
    }
}

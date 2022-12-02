package se.hernebring.day2.part1;

import se.hernebring.day2.Game;
import se.hernebring.day2.RockPaperScissors;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day2sample.txt");
        int score = 0;
        try(Scanner scanner = new Scanner(file)) {
            Game game = new Game();
            while(scanner.hasNext()) {
                String current = scanner.next();
                int diff = current.charAt(0) - 'A';
                RockPaperScissors o = RockPaperScissors.getFromZeroIndex(diff);
                game.opponentPlayed(o);

                current = scanner.next();
                diff = current.charAt(0) - 'X';
                RockPaperScissors u = RockPaperScissors.getFromZeroIndex(diff);
                game.wePlayed(u);

                score += game.getOurScore();
            }
        }
        System.out.println(score);
    }
}

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
            Game g = new Game();
            while(scanner.hasNext()) {
                String opponent = scanner.next();
                RockPaperScissors o = switch (opponent) {
                    case "A" -> RockPaperScissors.ROCK;
                    case "B" -> RockPaperScissors.PAPER;
                    case "C" -> RockPaperScissors.SCISSORS;
                    default -> null;
                };
                g.opponentPlayed(o);
                String us = scanner.next();
                RockPaperScissors u = switch (us) {
                    case "X" -> RockPaperScissors.ROCK;
                    case "Y" -> RockPaperScissors.PAPER;
                    case "Z" -> RockPaperScissors.SCISSORS;
                    default -> null;
                };
                g.wePlayed(u);
                score += g.getOurScore();
            }
            System.out.println(score);
        }
    }
}

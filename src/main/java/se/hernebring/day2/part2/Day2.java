package se.hernebring.day2.part2;

import se.hernebring.day2.Game;
import se.hernebring.day2.RockPaperScissors;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static se.hernebring.day2.RockPaperScissors.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day2sample.txt");
        int score = 0;
        try(Scanner scanner = new Scanner(file)) {
            Game g = new Game();
            while(scanner.hasNext()) {
                String opponent = scanner.next();
                RockPaperScissors o = switch (opponent) {
                    case "A" -> ROCK;
                    case "B" -> PAPER;
                    case "C" -> SCISSORS;
                    default -> null;
                };
                g.opponentPlayed(o);
                String us = scanner.next();
                RockPaperScissors u;
                switch(us) {
                    case "X" -> {
                        if(o == ROCK)
                            u = SCISSORS;
                        else if(o == PAPER)
                            u = ROCK;
                        else
                            u = PAPER;
                    }
                    case "Y" -> u = o;
                    case "Z" -> {
                        if(o == ROCK)
                            u = PAPER;
                        else if(o == PAPER)
                            u = SCISSORS;
                        else
                            u = ROCK;
                    }
                    default -> u = null;
                }
                g.wePlayed(u);
                score += g.getOurScore();
            }
            System.out.println(score);
        }
    }
}

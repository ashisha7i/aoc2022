package se.hernebring.day2.part2;

import se.hernebring.day2.part1.Game;
import se.hernebring.day2.part1.RockPaperScissors;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;
import static se.hernebring.day2.part1.RockPaperScissors.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day2.txt");
//        List<String> lines = readAllLines(file.toPath());
//        for(String l : lines)
//            System.out.println(l);

// ALTERNATIVE
        int score = 0;
        try(Scanner scanner = new Scanner(file)) {
            Game g = new Game();
            while(scanner.hasNext()) {
                String opponent = scanner.next();
                RockPaperScissors o;
                switch(opponent) {
                    case "A" : o = RockPaperScissors.ROCK; break;
                    case "B" : o = RockPaperScissors.PAPER; break;
                    case "C" : o = RockPaperScissors.SCISSORS; break;
                    default: o = null;
                }
                g.opponentPlayed(o);
                String us = scanner.next();
                RockPaperScissors u;
                switch(us) {
                    case "X" : if(o == ROCK)
                            u = SCISSORS;
                        else if(o == PAPER)
                            u = ROCK;
                        else
                            u = PAPER;
                        break;
                    case "Y" : u = o; break;
                    case "Z" : if(o == ROCK)
                            u = PAPER;
                        else if(o == PAPER)
                            u = SCISSORS;
                        else
                            u = ROCK;
                        break;
                    default: u = null;
                }
                g.wePlayed(u);
                score += g.getOurScore();
            }
            System.out.println(score);
        }

// ALTERNATIVE FOR FUNCTIONAL STRING MANIPULATION
//        String.join(",", readAllLines(file.toPath()));
    }
}

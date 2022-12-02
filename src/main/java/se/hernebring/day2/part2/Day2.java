package se.hernebring.day2.part2;

import se.hernebring.day2.Game;
import se.hernebring.day2.RockPaperScissors;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/day2samplePart2.txt");
        int score = 0;
        try(Scanner scanner = new Scanner(file)) {
            Game g = new Game();
            while(scanner.hasNext()) {
                String current = scanner.next();
                int diff = current.charAt(0) - 'A';
                RockPaperScissors opponent = RockPaperScissors.getFromZeroIndex(diff);
                g.opponentPlayed(opponent);

                current = scanner.next();
                RockPaperScissors u = wePlayAgainst(current, opponent);
                g.wePlayed(u);

                score += g.getOurScore();
            }
            System.out.println(score);
        }
    }

    private static RockPaperScissors wePlayAgainst(String current, RockPaperScissors opponent) {
        RockPaperScissors weWillDraw = Game.drawingStrategy(opponent);
        if(!current.equals("Y")) {
            RockPaperScissors weWillWin = Game.winningStrategy(opponent);
            if(current.equals("Z"))
                return weWillWin;
            else
                return Stream.of(RockPaperScissors.values())
                        .filter(v -> v != weWillWin & v != weWillDraw)
                        .findFirst().orElseThrow(IllegalStateException::new);

        }
        return weWillDraw;
    }
}

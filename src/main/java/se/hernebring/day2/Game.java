package se.hernebring.day2;

import static se.hernebring.day2.RockPaperScissors.*;

public class Game {
    private RockPaperScissors opponent;
    private RockPaperScissors us;

    public void opponentPlayed(RockPaperScissors rps) {
        this.opponent = rps;
    }

    public void wePlayed(RockPaperScissors rps) {
        this.us = rps;
    }

    public int getOurScore() {
        int score = 0;
        if(weWon())
            score += 6;
        else if(weDrew())
            score += 3;

        return score + us.getValue();
    }

    public static RockPaperScissors drawingStrategy(RockPaperScissors opponent) {
        return opponent;
    }

    public static RockPaperScissors winningStrategy(RockPaperScissors opponent) {
        Game inTheFuture = new Game();
        inTheFuture.opponentPlayed(opponent);
        for(RockPaperScissors v : RockPaperScissors.values()) {
            inTheFuture.wePlayed(v);
            if(inTheFuture.weWon())
                return v;

        }
        return null;
    }

    private boolean weWon() {
        return (opponent == ROCK & us == PAPER) |
                (opponent == PAPER & us == SCISSORS) |
                (opponent == SCISSORS & us == ROCK);
    }

    private boolean weDrew() {
        return opponent == us;
    }
}

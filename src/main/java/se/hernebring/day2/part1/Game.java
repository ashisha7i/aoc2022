package se.hernebring.day2.part1;

import static se.hernebring.day2.part1.RockPaperScissors.*;

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
        if((opponent == ROCK & us == PAPER) | (opponent == PAPER & us == SCISSORS) | (opponent == SCISSORS & us == ROCK))
            score += 6;
        else if((opponent == ROCK & us == ROCK) | (opponent == PAPER & us == PAPER) | (opponent == SCISSORS & us == SCISSORS)) {
            score += 3;
        }
        return score + us.getValue();
    }
}

package se.hernebring.day2.part1;

import org.junit.jupiter.api.Test;
import se.hernebring.day2.Game;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static se.hernebring.day2.RockPaperScissors.PAPER;
import static se.hernebring.day2.RockPaperScissors.ROCK;

class Day2Test {

    @Test
    void opponentRockChosePaper() {
        var rps = new Game();
        rps.opponentPlayed(ROCK);
        rps.wePlayed(PAPER);
        int result = rps.getOurScore();
        assertEquals(8, result);
    }

    @Test
    void opponentPaperChoseRock() {
        var rps = new Game();
        rps.opponentPlayed(PAPER);
        rps.wePlayed(ROCK);
        int result = rps.getOurScore();
        assertEquals(1, result);
    }

    @Test
    void mainPrints15AfterScoring() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day2.main(null));
        assertEquals("15", bos.toString().trim());
        System.setOut(System.out);
    }
}

package se.hernebring.day2.part2;

import org.junit.jupiter.api.Test;
import se.hernebring.day2.RockPaperScissors;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static se.hernebring.day2.RockPaperScissors.ROCK;

class Day2Test {

    @Test
    void weWantsToLoseAgainstOpponentRock() {
        RockPaperScissors o = ROCK;

    }


    @Test
    void mainPrints12AfterScoring() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day2.main(null));
        assertEquals("34", bos.toString().trim());
        System.setOut(System.out);
    }
}

package se.hernebring.day8;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Test {

    @Test
    void mainPrintsVisibleTreesCountAndBestSpotScoreFromTextFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day8.main(null));
        assertEquals("21" + System.lineSeparator() + "8", bos.toString().trim());
        System.setOut(System.out);
    }
}

package se.hernebring.day2.part2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @Test
    void mainPrints34AfterScoringWithModifiedSample() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day2.main(null));
        assertEquals("34", bos.toString().trim());
        System.setOut(System.out);
    }
}

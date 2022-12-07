package se.hernebring.day7;

import org.junit.jupiter.api.Test;
import se.hernebring.day7.part1.Day7;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {

    @Test
    void mainPrintsSumOfDirectoriesUnder100k() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day7.main(null));
        assertEquals("95437", bos.toString().trim());
        System.setOut(System.out);
    }
}

package se.hernebring.day1.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.hernebring.day1.part1.Day1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void mainPrints24000TextFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day1.main(null));
        assertEquals("24000", bos.toString().trim());
        System.setOut(System.out);
    }
}

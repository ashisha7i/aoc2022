package se.hernebring.day1.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.hernebring.day1.part1.Day1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    private ByteArrayOutputStream bos;

    @BeforeEach
    void init() {
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        System.setOut(System.out);
    }

    @Test
    void mainPrints24000TextFile() {
        assertDoesNotThrow(() -> Day1.main(null));
        assertEquals("24000", bos.toString().trim());
    }
}

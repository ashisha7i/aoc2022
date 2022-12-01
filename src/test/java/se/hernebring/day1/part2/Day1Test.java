package se.hernebring.day1.part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("45000", bos.toString().trim());
    }
}

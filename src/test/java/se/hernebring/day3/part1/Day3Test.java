package se.hernebring.day3.part1;

import org.junit.jupiter.api.Test;
import se.hernebring.day3.part1.Day3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    @Test
    void mainPrintsHelloWorldFromTextFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day3.main(null));
        assertEquals("157", bos.toString().trim());
        System.setOut(System.out);
    }
}

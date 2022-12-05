package se.hernebring.day5.part1;

import org.junit.jupiter.api.Test;
import se.hernebring.day5.Day5;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Test {

    @Test
    void mainPrintsHelloWorldFromTextFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day5.main(null));
        assertEquals("CMZ", bos.toString().trim());
        System.setOut(System.out);
    }

}

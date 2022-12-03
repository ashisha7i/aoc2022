package se.hernebring.day4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Test {

    @Test
    void mainPrintsHelloWorldFromTextFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day4.main(null));
        assertEquals("Hello world!", bos.toString().trim());
        System.setOut(System.out);
    }
}

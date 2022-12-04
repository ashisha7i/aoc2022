package se.hernebring.day4.part1;

import org.junit.jupiter.api.Test;
import se.hernebring.day4.part1.Day4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    @Test
    void mainPrintsHelloWorldFromTextFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day4.main(null));
        assertNotEquals("978", bos.toString().trim());
        assertNotEquals("657", bos.toString().trim());
        System.setOut(System.out);
    }
}

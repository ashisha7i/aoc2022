package se.hernebring.day7.part2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {

    @Test
    void mainPrintsSmallestDirectoryUnderThreshold() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day7.main(null));
        assertEquals("24933642", bos.toString().trim());
        System.setOut(System.out);
    }
}

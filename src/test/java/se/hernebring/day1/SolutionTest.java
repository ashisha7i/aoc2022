package se.hernebring.day1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void mainPrints24000And45000ToSystemOut() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Solution.main(null));
        assertEquals("24000" + System.lineSeparator() + "45000", bos.toString().trim());
        System.setOut(System.out);
    }
}

package se.hernebring.day1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private ByteArrayOutputStream bos;

    @BeforeEach
    void init() {
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    @AfterEach
    void close() {
        System.setOut(System.out);
    }

    @Test
    void mainPrints24000And45000ToSystemOut() {
        assertDoesNotThrow(() -> Solution.main(null));
        assertEquals("24000" + System.lineSeparator() + "45000", bos.toString().trim());
    }

    @Test
    void alternativeMainPrints24000And45000ToSystemOut() {
        assertDoesNotThrow(() -> AlternativeSolution.main(null));
        assertEquals("24000" + System.lineSeparator() + "45000", bos.toString().trim());
    }
}

package se.hernebring.day7;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {

    @Test
    void mainPrintsSumOfDirectioriesUnder100k() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        assertDoesNotThrow(() -> Day7.main(null));
        assertEquals("95437", bos.toString().trim());
        System.setOut(System.out);
    }

//    @Test
//    void mainPrintsFileSystemFromTextFile() {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(bos));
//        assertDoesNotThrow(() -> Day7.main(null));
//        assertEquals("""
//                - / (dir)
//                  - a (dir)
//                    - e (dir)
//                      - i (file, size=584)
//                    - f (file, size=29116)
//                    - g (file, size=2557)
//                    - h.lst (file, size=62596)
//                  - b.txt (file, size=14848514)
//                  - c.dat (file, size=8504156)
//                  - d (dir)
//                    - j (file, size=4060174)
//                    - d.log (file, size=8033020)
//                    - d.ext (file, size=5626152)
//                    - k (file, size=7214296)""", bos.toString().trim());
//        System.setOut(System.out);
//    }
}

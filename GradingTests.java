import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GradingTests {
    @Test
    public void testFile1() {
        List<String> expect = List.of("");
        assertEquals(MarkdownParse.getLinks("[]()"), expect);
    }
    @Test
    public void testFile2() {
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks("[]("), expect);
    }

}

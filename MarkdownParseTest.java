import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class MarkdownParseTest {

    
    @Test
    public void snippet1Test() throws IOException{
        Path fileName = Path.of("Snippet1.md");
        String contents = Files.readString(fileName);
        ArrayList <String> links = MarkdownParse.getLinks(contents);
        ArrayList <String> list = new ArrayList<String>();
        list.add("`google.com");
        list.add("google.com");
        list.add("ucsd.edu");
        assertEquals(list, links);
    }
    @Test
    public void snippet2Test() throws IOException{
        Path fileName = Path.of("Snippet2.md");
        String contents = Files.readString(fileName);
        ArrayList <String> links = MarkdownParse.getLinks(contents);
        ArrayList <String> list = new ArrayList<String>();
        list.add("a.com");
        list.add("a.com(())");
        list.add("example.com");
        assertEquals(list, links);
    }
    @Test
    public void snippet3Test() throws IOException{
        Path fileName = Path.of("Snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList <String> links = MarkdownParse.getLinks(contents);
        ArrayList <String> list = new ArrayList<String>();
        list.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals(list, links);
    }
}
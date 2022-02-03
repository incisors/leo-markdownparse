// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(markdown.indexOf("[", currentIndex) != -1) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket - 1) == '!'){
                int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
                if(nextCloseBracket == -1){
                    nextCloseBracket = nextOpenBracket;
                }
                int openParen = markdown.indexOf("(", nextCloseBracket);
                if(openParen == -1){
                    openParen = nextOpenBracket;
                }
                int closeParen = markdown.indexOf(")", openParen);
                if(closeParen == -1){
                    closeParen = openParen;
                }
                currentIndex = closeParen + 1;
            }
            else{
                int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
                if(nextCloseBracket == -1){
                    nextCloseBracket = nextOpenBracket;
                }
                int openParen = markdown.indexOf("(", nextCloseBracket);
                if(openParen == -1){
                    openParen = nextOpenBracket;
                }
                int closeParen = markdown.indexOf(")", openParen);
                if(closeParen == -1){
                    closeParen = openParen;
                }
                if(nextCloseBracket != openParen - 1){
                    currentIndex = closeParen + 1;
                }
                else{
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                }
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
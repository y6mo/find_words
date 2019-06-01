import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class WordsTest {

    //check for vertical and horizontal search cases
    @Test
    public void wordSearch1() {
        char [][] grid = {{'h', 'e', 'l', 'p'},
                          {'e', 'h', 'l', 'q'},
                          {'l', 'l', 'o', 'x'},
                          {'c', 'a', 'b', 'l'}};
        Set<String> set = new HashSet<>(Arrays.asList("hello", "help", "howdy", "hel", "ehl"));

        Set<String> actual = Words.wordSearch(grid, set);
        List<String> expected = Arrays.asList("ehl", "hello", "hel", "help");

        assertTrue(actual.size() == expected.size() &&
                actual.containsAll(expected) && expected.containsAll(actual));
    }

    //check for horizontal, vertical, and diagonal search cases
    @Test
    public void wordSearch2() {
        char [][] grid = {{'g', 'o', 'o', 'p'},
                          {'a', 'd', 'l', 'q'},
                          {'l', 'l', 'e', 'x'},
                          {'c', 'a', 'b', 'l'}};
        Set<String> set = new HashSet<>(Arrays.asList("cable", "goo", "goop", "ale", "lao", "qxlbo"));

        Set<String> actual = Words.wordSearch(grid, set);
        List<String> expected = Arrays.asList("cable", "goo", "goop", "ale", "lao");

        assertTrue(actual.size() == expected.size() &&
                actual.containsAll(expected) && expected.containsAll(actual));
    }

    //check same tile is not used again
    @Test
    public void wordSearch3() {
        char [][] grid = {{'a', 'b', 'c', 'd'},
                          {'e', 'f', 'g', 'h'},
                          {'i', 'j', 'k', 'l'},
                          {'m', 'n', 'o', 'p'}};
        Set<String> set = new HashSet<>(Arrays.asList("aba", "njnfb", "dhknmiea"));

        Set<String> actual = Words.wordSearch(grid, set);
        List<String> expected = Arrays.asList("dhknmiea");

        assertTrue(actual.size() == expected.size() &&
                actual.containsAll(expected) && expected.containsAll(actual));
    }

    //check that same character can be used as long as tile is different
    @Test
    public void wordSearch4() {
        char [][] grid = {{'a', 'b', 'c', 'a'},
                          {'e', 'f', 'g', 'h'},
                          {'i', 'j', 'k', 'l'},
                          {'m', 'n', 'o', 'j'}};
        Set<String> set = new HashSet<>(Arrays.asList("aba", "abca", "fghljonj", "njnfb"));

        Set<String> actual = Words.wordSearch(grid, set);
        List<String> expected = Arrays.asList("abca", "fghljonj");

        assertTrue(actual.size() == expected.size() &&
                actual.containsAll(expected) && expected.containsAll(actual));
    }

    //more tests for good measure
    @Test
    public  void wordSearch5() {
        char [][] grid = {{'a', 'b', 'c', 'a'},
                          {'e', 'f', 'g', 'h'},
                          {'i', 'j', 'k', 'l'},
                          {'m', 'n', 'o', 'j'}};
        Set<String> set = new HashSet<>(Arrays.asList("kojlhgfea", "mjga", "ahljokgc", "abac", "kjab", "jbc"));

        Set<String> actual = Words.wordSearch(grid, set);
        List<String> expected = Arrays.asList("kojlhgfea", "mjga", "ahljokgc");

        assertTrue(actual.size() == expected.size() &&
                actual.containsAll(expected) && expected.containsAll(actual));
    }
}

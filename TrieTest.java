import static org.junit.Assert.*;
import org.junit.Test;

public class TrieTest {

    //check to find something not there
    @Test
    public void find1() {
        Trie trie = new Trie();
        assertFalse(trie.find("hi"));
    }

    //check to find word after insertion
    @Test
    public void find2() {
        Trie trie = new Trie();
        trie.insert("hello");
        assertTrue(trie.find("hello"));
    }

    //check to find part of word that was inserted
    @Test
    public void find3() {
        Trie trie = new Trie();
        trie.insert("abcd");
        assertFalse(trie.find("abc"));
    }

    //check to find a word with suffix of previously inserted word
    @Test
    public void find4() {
        Trie trie = new Trie();
        trie.insert("abc");
        assertFalse(trie.find("abce"));
    }

    //check for prefix with correct prefix
    @Test
    public void isPrefix1() {
        Trie trie = new Trie();
        trie.insert("hello");
        assertTrue(trie.isPrefix("h"));
    }

    //check that a word is not its own prefix
    @Test
    public void isPrefix2() {
        Trie trie = new Trie();
        trie.insert("hello");
        assertFalse(trie.isPrefix("hello"));
    }

    //check word that has different suffix as previously inserted word
    @Test
    public void isPrefix3() {
        Trie trie = new Trie();
        trie.insert("hello");
        assertFalse(trie.isPrefix("help"));
    }

    //another check for correct prefix
    @Test
    public void isPrefix4() {
        Trie trie = new Trie();
        trie.insert("goodbye");
        assertTrue(trie.isPrefix("good"));
    }
}

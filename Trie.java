public class Trie{
    private Node root;

    public Trie() {
        root = new Node();
    }

    public boolean find(String word){
        if (word == null){
            return false;
        }
        Node current = root;
        for (int i = 0; i < word.length(); i++){
            if (current.letters.containsKey(word.charAt(i))){
                current = current.letters.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return current.isWord;
    }

    //returns whether an input string is a prefix of a word in a Trie
    public boolean isPrefix(String word){
        if (word == null){
            return false;
        }
        Node current = root;
        for (int i = 0; i < word.length(); i++){
            if (current.letters.containsKey(word.charAt(i))){
                current = current.letters.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return !current.letters.isEmpty();
    }

    public void insert(String word){
        //words must be 3 or more letters by problem statement
        if (word == null || word.length() < 3){
            return;
        }
        Node current = root;
        for (int i = 0; i < word.length(); i++){
            if (!current.letters.containsKey(word.charAt(i))){
                current.letters.put(word.charAt(i), new Node());
            }
            current = current.letters.get(word.charAt(i));
        }
        current.isWord = true;
    }

}


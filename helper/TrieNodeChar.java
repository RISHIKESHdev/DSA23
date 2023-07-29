package helper;

public class TrieNodeChar {
    public TrieNodeChar[] character;
    public boolean isEndOfWord;
    public int prefixCount;
    public TrieNodeChar() {
            isEndOfWord = false;
            character = new TrieNodeChar[26];
            prefixCount= 0;
        }
}

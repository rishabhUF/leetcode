package trie;

public class TrieNode {
    char val;
    TrieNode[] children;
    boolean isWord;

    TrieNode(char c) {
        this.val = c;
        children = null;
    }
}

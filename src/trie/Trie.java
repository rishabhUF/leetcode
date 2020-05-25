package trie;

public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++) {
            if(temp.children == null) {
                temp.children = new TrieNode[26];
                temp.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            } else if (temp.children[word.charAt(i)-'a'] == null) {
                temp.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            temp = temp.children[word.charAt(i)-'a'];
            if(i == n-1) {
                temp.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length();i++) {
            if(temp.children == null || temp.children[word.charAt(i)-'a'] ==null)
                return false;
            else {
                temp = temp.children[word.charAt(i)-'a'];
            }
            if(i == word.length()-1)
                return temp.isWord;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        if(temp.children == null)
            return false;
        for(int i=0;i<prefix.length();i++) {
            if(temp.children == null || temp.children[prefix.charAt(i)-'a'] == null) {
                return false;
            } else {
                temp = temp.children[prefix.charAt(i)-'a'];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        trie.insert("apple");
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("hell"));
        System.out.println(trie.startsWith("helloa"));
        System.out.println(trie.startsWith("hello"));
    }
}

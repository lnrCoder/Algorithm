package com.liang.leetcode.daily.APR21;

/**
 * 实现 Trie (前缀树)
 *
 * @author LiaNg
 * @date 2021/4/14 16:33
 */
public class Trie {


    boolean isWord;

    Trie[] children;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie trie = this;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new Trie();
            }
            trie = trie.children[index];
        }
        trie.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

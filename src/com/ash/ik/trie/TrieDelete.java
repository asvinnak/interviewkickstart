package com.ash.ik.trie;



public class TrieDelete {

        private static final Integer ALPHABET_SIZE = 26;

    private static TrieNode root;

    static class TrieNode {

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    public static void insertTrieNode(String key) {
        int idx;

        TrieNode pcrawl = root;

        for (int i = 0; i < key.length(); i++) {
            idx = key.charAt(i) - 'a';

            if (pcrawl.children[idx] == null) {
                pcrawl.children[idx] = new TrieNode();
            }

            pcrawl = pcrawl.children[idx];
        }

        pcrawl.isEndOfWord = true;
    }

    public static boolean search(String key) {
        int idx;

        TrieNode pcrawl = root;
        for (int i = 0; i < key.length(); i++) {
            idx = key.charAt(i) - 'a';

            if (pcrawl.children[idx] == null) {
                return false;
            }
            pcrawl = pcrawl.children[idx];
        }

        return pcrawl != null && pcrawl.isEndOfWord;
    }

    private static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static TrieNode delete(TrieNode root, String key, int depth) {

        if (root == null) {
            return null;
        }

        if (depth == key.length()) {

            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }

            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }

        int idx = key.charAt(depth) - 'a';
        root.children[idx] = delete(root, key, depth + 1);

        if (isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }

        return root;
    }

    public static void main(String args[]) {
        String[] keys = { "the", "a", "there", "answer", "any", "by", "bye", "their", "hero", "heroplane" };

        root = new TrieNode();

        for (int i = 0; i < keys.length; i++) {
            insertTrieNode(keys[i]);
        }

        if (search("heroplane") == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        if (search("these") == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        delete(root, "heroplane", 0);

        if (search("heroplane") == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        if (search("hero") == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

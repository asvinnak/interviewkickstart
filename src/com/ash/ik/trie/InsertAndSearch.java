package com.ash.ik.trie;

import sun.text.normalizer.Trie;

public class InsertAndSearch {

    private static TrieNode root;

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isEndofWord;

        TrieNode() {
            isEndofWord = false;
            for (int i=0; i< ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }

    }

    static void insert(String key) {
        int level;
        int length= key.length();
        int index;

        TrieNode pcrawl= root;

        for(level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if(pcrawl.children[index] == null) {
                pcrawl.children[index] = new TrieNode();
            }
            pcrawl = pcrawl.children[index];
        }

        //marks last node as leaf
        pcrawl.isEndofWord = true;
    }


    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {

            index = key.charAt(level) - 'a';

            if(pCrawl.children[index] == null) {
                return false;
            }

            pCrawl = pCrawl.children[index];
        }

        return pCrawl != null && pCrawl.isEndofWord;
    }


    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();

        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);


        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);


    }
}

package com.ash.ik.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language. Examples:
 * <p>
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"} Output: Order of characters is 'b', 'd', 'a', 'c' Note that
 * words are sorted and in the given language "baa" comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * <p>
 * Input:  words[] = {"caa", "aaa", "aab"} Output: Order of characters is 'c', 'a', 'b'
 */
public class SortDictionaryAlienLanguage {

    static String find_order(String[] words) {

        Map<Character, List<Character>> adjMap = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                adjMap.put(words[i].charAt(j), new ArrayList<>());
                indegree.put(words[i].charAt(j), 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            char[] first = words[i].toCharArray();
            char[] second = words[i + 1].toCharArray();

            int min = Math.min(first.length, second.length);

            for (int k = 0; k < min; k++) {
                if (first[k] != second[k]) {
                    adjMap.get(first[k]).add(second[k]);
                    indegree.put(second[k], indegree.get(second[k]) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (Character key : adjMap.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }

        while (!queue.isEmpty()) {

            Character ch = queue.remove();

            sb.append(ch);

            for (Character child : adjMap.get(ch)) {
                indegree.put(child, indegree.get(child) - 1);
                if (indegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        return sb.toString();
    }
}

package com.ash.ik.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    private static List<List<String>> groupAnagrams(String[] sArray) {

        if (sArray == null || sArray.length == 0) {
            return new ArrayList<>();
        }

        List<List<String>> groupAnagramList = new ArrayList<>();

        char[] word;
        String key = "";
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            word = sArray[i].toCharArray();
            Arrays.sort(word);
            key = String.valueOf(word);
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(sArray[i]);
        }
        groupAnagramList.addAll(map.values());
        return groupAnagramList;
    }

    public static void main(String[] args) {

        String[] sArray = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> anagrams = groupAnagrams(sArray);

        System.out.println(Arrays.deepToString(anagrams.toArray()));
    }
}

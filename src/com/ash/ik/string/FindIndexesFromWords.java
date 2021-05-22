package com.ash.ik.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIndexesFromWords {

    public List<Integer> findSubstring(String s, String[] words) {


        List<Integer> indexes = new ArrayList<>();

        if(s == null || s.isEmpty() || words == null || words.length == 0) {
            return indexes;
        }

        int len = words.length;
        List targetList = Arrays.asList(words);
        int wordSize= words[0].length();
        Arrays.sort(words);
        StringBuilder sb= new StringBuilder();
        for(int i=0; i< len; i++) {
            sb.append(words[i]);
        }
        String target = sb.toString();


        if(target.equals(s)) {
            indexes.add(0);
        } else {
            String word;
            for (int i = 0; i < s.length() - len; i++) {
                word = s.substring(i, i + wordSize);
                if (targetList.contains(word)) {
                    String s1 = s.substring(i, s.length());
                    String[] chops = s1.split("(?<=\\G.{" + wordSize + "})");
                    int len2 = chops.length;
                    String formed;
                    int endIdx;

                    for (int k = 0; k < len2; k++) {
                        endIdx = k + len - 1 < len2 ? k + len - 1 : len2 - 1;
                        formed = getFormedString(chops, k, endIdx);
                        if (target.equals(formed)) {
                            indexes.add(i + (k * wordSize));
                        }
                    }
                    break;
                }
            }
        }


        return indexes;
    }

    private String getFormedString(String[] chops, int startIdx, int endIdx) {
        int j=0;
        String[] newChops= new String[endIdx - startIdx + 1];
        for(int i=startIdx; i<= endIdx; i++) {
            newChops[j] = chops[i];
            j++;
        }
        Arrays.sort(newChops);
        StringBuilder sb= new StringBuilder();

        for(int i=0; i< newChops.length; i++) {
            sb.append(newChops[i]);
        }

        return sb.toString();

    }

    public static void main(String[] s) {
        FindIndexesFromWords o = new FindIndexesFromWords();
        String sx = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] p= {"fooo","barr","wing","ding","wing"};
        o.findSubstring(sx, p).forEach(System.out::print);

        String sx1 = "barfoothefoobarman";
        String[] p1= {"foo","bar"};
        o.findSubstring(sx1, p1).forEach(System.out::print);

        String sx2 = "wordgoodgoodgoodbestword";
        String[] p2= {"word","good","best","word"};
        o.findSubstring(sx2, p2).forEach(System.out::print);

        String sx3 = "aaaaaaaa";
        String[] p3= {"aa","aa","aa"};
        o.findSubstring(sx3, p3).forEach(System.out::print);

    }

}

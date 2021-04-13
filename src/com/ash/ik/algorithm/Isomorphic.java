package com.ash.ik.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {

        if(s.equalsIgnoreCase(t)) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        char[] fchar = new char[t.length()];
        for(int i=0; i< schar.length; i++) {
            if(map.get(schar[i]) != null) {
                fchar[i] = map.get(schar[i]);
            } else {
                if(map.values().contains(tchar[i])) {
                    return false;
                }
                map.put(schar[i], tchar[i]);
                fchar[i] = tchar[i];
            }
        }

        String out = String.valueOf(fchar);
        return out.equals(t);
    }

    public boolean isIsomorphic1(String s, String t) {

        if(s.equalsIgnoreCase(t)) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        char[] fchar = new char[t.length()];
        for(int i=0; i< schar.length; i++) {
            if(map.values().contains(tchar[i])) {
                return false;
            }
            fchar[i] = map.get(schar[i]) != null ? map.get(schar[i]) : tchar[i];
            map.put(schar[i], tchar[i]);
        }

        String out = String.valueOf(fchar);
        return out.equals(t);
    }

    public static void  main(String[] args) {
        Isomorphic o = new Isomorphic();
        System.out.println(o.isIsomorphic("ab", "aa"));
    }


}

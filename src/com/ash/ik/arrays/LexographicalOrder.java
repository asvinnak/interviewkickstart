package com.ash.ik.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Lexicographical Order Lexicographical Order
 * <p>
 * <p>
 * <p>
 * Given a bunch of key-value pairs, for each unique key find 1) the number of values and 2) the lexicographically
 * greatest value.
 * <p>
 * <p>
 * <p>
 * Example One
 * <p>
 * Input is an array of strings, each with a key and a value separated by a space:
 * <p>
 * ["key1 abcd",
 * <p>
 * "key2 zzz",
 * <p>
 * "key1 hello",
 * <p>
 * "key3 world",
 * <p>
 * "key1 hello"]
 * <p>
 * <p>
 * <p>
 * Output is an array of strings with unique keys followed by a colon, the total number of values, a comma, and the
 * lexicographically greatest of the values associated with that key in the input:
 * <p>
 * ["key1:3,hello",
 * <p>
 * "key2:1,zzz",
 * <p>
 * "key3:1,world"]
 * <p>
 * The order or strings in the output is insignificant; these same strings in a different order are also a correct
 * output.
 * <p>
 * <p>
 * <p>
 * Example Two
 * <p>
 * Input:
 * <p>
 * ["mark zuckerberg",
 * <p>
 * "tim cook",
 * <p>
 * "mark twain"]
 * <p>
 * <p>
 * <p>
 * Output:
 * <p>
 * ["mark:2,zuckerberg",
 * <p>
 * "tim:1,cook"]
 * <p>
 * or
 * <p>
 * ["tim:1,cook",
 * <p>
 * "mark:2,zuckerberg"]
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Order of strings in the output does not matter.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Keys and values consist of lowercase letters and digits. 1 <= number of strings in input <= 10^4 1 <= length of any
 * key <= 256 1 <= length of any value <= 650 Keys can repeat. Values can repeat.
 * <p>
 * <p>
 * Custom Input
 * <p>
 * Input Format:
 * <p>
 * The first line of input contains the number of strings.
 * <p>
 * The input strings then follow, each on its own line.
 * <p>
 * Example:
 * <p>
 * 5
 * <p>
 * key1 abcd
 * <p>
 * key2 zzz
 * <p>
 * key1 hello
 * <p>
 * key3 world
 * <p>
 * key1 hello
 * <p>
 * <p>
 * <p>
 * Output Format:
 * <p>
 * Each of the output strings should appear on its own line.
 * <p>
 * Example:
 * <p>
 * key3:1,world
 * <p>
 * key2:1,zzz
 * <p>
 * key1:3,hello
 */
public class LexographicalOrder {

    static String[] solve(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        String[] sarray = null;
        for (int i = 0; i < arr.length; i++) {
            sarray = arr[i].split(" ");

            if (!map.containsKey(sarray[0])) {
                map.put(sarray[0], new ArrayList<>());
            }
            map.get(sarray[0]).add(sarray[1]);
        }

        String[] result = new String[map.keySet().size()];
        Iterator itr = map.entrySet().iterator();

        int i = 0;

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result[i] = populateString(entry.getKey(), entry.getValue());
            i++;
        }

        return result;
    }

    private static String populateString(String key, List<String> values) {

        StringBuilder sb = new StringBuilder(key).append(":").append(values.size()).append(",");
        TreeMap<String, Integer> map = new TreeMap<>();
        String highest = null;
        int valueCnt;
        int highestCnt = 1;
        for (String v : values) {
            if (!map.containsKey(v)) {
                map.put(v, 0);
            }
            valueCnt = map.get(v) + 1;
            map.put(v, valueCnt);
            if (highestCnt < valueCnt) {
                highestCnt = valueCnt;
                highest = v;
            }
        }
        return sb.append(highestCnt > 1 ? highest : map.pollLastEntry().getKey()).toString();
    }



    static String[] solveBetterApproach(String[] arr) {
        /*
         * Write your code here.
         */
        class InternalClass {
            int number;
            String value;
        }
        Map<String, InternalClass> map = new HashMap<>();
        for(String s : arr) {
            String key = s.substring(0,s.indexOf(" "));
            String value = s.substring(s.indexOf(" ")+1,s.length());
            InternalClass internal = map.get(key);
            if(internal == null) {
                internal = new InternalClass();
                internal.number = 1;
                internal.value = value;
                map.put(key,internal);
                continue;
            }
            internal.number = internal.number+1;
            if(value.compareTo(internal.value) > 0) {
                internal.value = value;
            }
        }
        String[] ret = new String[map.size()];
        int i=0;
        for(Map.Entry<String,InternalClass> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey());
            sb.append(":");
            InternalClass internal = entry.getValue();
            sb.append(internal.number);
            sb.append(",");
            sb.append(internal.value);
            ret[i] = sb.toString();
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {

        String[] arr = new String[] { "mark zuckerberg", "tim cook", "mark twain" };
        String[] result = solveBetterApproach(arr);

        System.out.println(Arrays.deepToString(result));
    }
}

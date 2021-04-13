package com.ash.ik.string;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// a + b =  c
// b = c - a;
public class TwoSum {

    public static void main(String[] args) throws IOException {
        TwoSum o = new TwoSum();
        int[] num = { 2, 11, 15, 7, 1 };
        List<Integer> out = o.twoSum(num, 22);

        out.forEach(System.out::println);
    }

    private List<Integer> twoSum(int[] num, int t) {

        List<Integer> twoSumList= new ArrayList<>();
        int a;
        int diff;
        for(int i=0; i< num.length; i++) {

            diff = t - num[i];

            for(int j= i+1; j<num.length; j++) {
                if(num[j] == diff) {
                    twoSumList.addAll(Arrays.asList(num[j], num[i]));
                    break;
                }
            }
        }

        return twoSumList;
    }
}

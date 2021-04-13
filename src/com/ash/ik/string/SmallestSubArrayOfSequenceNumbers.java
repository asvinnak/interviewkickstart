package com.ash.ik.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SmallestSubArrayOfSequenceNumbers {


    public static List<Integer> findSmallestSubArrayNumSequence(int[] arr) {
        List<Integer> result= new ArrayList<>();

        Map<Integer, Integer> leftIdx= new HashMap<>();
        // num, count
        Map<Integer, Integer> occuranceCount= new HashMap<>();

        int maxOccurance = 0;
        int startIdx = -1;
        int minLen= -1;
        for(int i=0; i<arr.length; i++) {
            int v = arr[i];
            if(!occuranceCount.containsKey(v)) {
                occuranceCount.put(v, 1);
                leftIdx.put(v,i);
            } else {
                occuranceCount.put(v, occuranceCount.get(v) + 1);
            }

            if(occuranceCount.get(v) > maxOccurance) {
                maxOccurance = occuranceCount.get(v);
                minLen = i - leftIdx.get(v) +1;
                startIdx = leftIdx.get(v);
            } else if(occuranceCount.get(v) == maxOccurance &&
                i - leftIdx.get(v)+1 < minLen) {
                minLen = i - leftIdx.get(v)+1;
                startIdx = leftIdx.get(v);

            }
        }

        for(int i=startIdx; i<startIdx+minLen; i++) {
            result.add(arr[i]);
            System.out.print(arr[i] + " ");
        }

        return result;
    }


    static class DegreeInfo {
        int degree;
        int startIdx;
        int endIdx;

        public DegreeInfo(int degree, int startIdx, int endIdx) {
            this.degree = degree;
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }

        public void setEndIdx(int endIdx) {
            this.endIdx = endIdx;
        }
    }


    public static int findMinSubArray(int[] arr) {
        Map<Integer, DegreeInfo> map= new HashMap<>();

        int maxDegree= Integer.MIN_VALUE;
        int minLen= Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {

            int key= arr[i];
            if(!map.containsKey(arr[i])) {

                map.put(key, new DegreeInfo(1, i, i));
            } else {
                DegreeInfo o= map.get(key);
                o.degree++;
                o.setEndIdx(i);
                map.put(key, o);
            }

            if(maxDegree <= map.get(key).degree) {
                maxDegree = map.get(key).degree;
                minLen = map.get(key).endIdx - map.get(key).startIdx;
            } else if(maxDegree == map.get(key).degree && minLen > map.get(key).startIdx) {
                maxDegree = map.get(key).degree;
                minLen = map.get(key).endIdx - map.get(key).startIdx;
            }

        }

        return minLen;
    }

    public static void main(String[] args) {
        int[] arr= new int[] {1,2,2,3,1};
        findSmallestSubArrayNumSequence(arr);
        System.out.println("value:"+ findMinSubArray(arr));
    }
}

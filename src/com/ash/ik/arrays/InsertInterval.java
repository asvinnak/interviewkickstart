package com.ash.ik.arrays;

// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.ash.ik.string.AddTwoNumbersWithCarry;

/**
 * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; } }
 */

public class InsertInterval {

    static class Interval {

        public int start;

        public int end;

        Interval(int a, int b) {
            start = a;
            end = b;
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];

        for (int[] interval : intervals) {
            if(interval[0] < newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(4, 9));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        intervals.add(new Interval(14, 18));
        intervals = merge(intervals);


        for (Interval interval : intervals) {
            System.out.print("[");
            System.out.print(interval.start);
            System.out.print(",");
            System.out.print(interval.end);
            System.out.print("]");
            System.out.println();
        }

       // System.out.println(merge(array));

    }
}

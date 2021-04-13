package com.ash.ik.string;

/**
 * Write a method to replace all the spaces in a string with ‘%20’. You may assume that the string has sufficient space
 * at the end to hold the additional characters and that you are given the “true” length of the string. Examples:
 * <p>
 * Input: "Mr John Smith", 13 Output: Mr%20John%20Smith
 * <p>
 * Input: "Mr John Smith   ", 13 Output: Mr%20John%20Smith
 */
public class URLifyString {

    public static String replaceStringWithpercentile20(String s) {

        char[] carray = s.toCharArray();

        int totspaces = 0;
        for (int i = 0; i < carray.length; i++) {
            if (carray[i] == ' ') {
                totspaces++;
            }
        }

        int minusSpaces = 0;
        for (int j = carray.length - 1; j >= 0; j--) {
            if (carray[j] != ' ') {
                break;
            }
            minusSpaces++;
            totspaces--;
        }

        int afterspacesremovedatendlength = carray.length - minusSpaces;
        int finalLength = afterspacesremovedatendlength + 2 * totspaces;

        char[] orgCarray = carray;
        carray = new char[finalLength];
        int idx = finalLength - 1;

        for (int j = afterspacesremovedatendlength - 1; j >= 0; j--) {

            if (orgCarray[j] == ' ') {
                carray[idx] = '0';
                carray[idx - 1] = '2';
                carray[idx - 2] = '%';
                idx = idx - 3;
            } else {
                carray[idx] = orgCarray[j];
                idx--;
            }
        }

        return new String(carray);
    }

    public static void main(String[] args) {

        //System.out.println(replaceStringWithpercentile20("Mr John Smith"));

        System.out.println(replaceStringWithpercentile20("Mr John Smith    "));
    }
}





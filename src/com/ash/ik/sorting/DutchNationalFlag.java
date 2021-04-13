package com.ash.ik.sorting;

import java.io.IOException;

/**
 * Dutch National Flag Dutch National Flag
 * <p>
 * <p>
 * <p>
 * Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green
 * and then blue ones.
 * <p>
 * <p>
 * <p>
 * Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are
 * looking for.
 * <p>
 * <p>
 * <p>
 * This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch
 * national flag has three colors (albeit different from ones used in this problem).
 * <p>
 * <p>
 * <p>
 * Example
 * <p>
 * Input: [G, B, G, G, R, B, R, G]
 * <p>
 * Output: [R, R, G, G, G, G, B, B]
 * <p>
 * <p>
 * <p>
 * There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Parameters: An array of characters named balls, consisting of letters from {‘R’, ‘G’, ‘B’}.
 * <p>
 * <p>
 * <p>
 * Output: Return type is void. Modify the input character array by rearranging the characters in-place.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 100000 Do this in ONE pass over the array - NOT TWO passes, just one pass. Solution is only allowed to use
 * constant extra memory.
 * <p>
 * <p>
 * Custom Input
 * <p>
 * Input Format: The first line of input should contain an integer n, denoting the number of balls. In the next n lines,
 * i-th line should contain one letter from {'R', 'G', 'B'}, balls[i], denoting the color of the i-th ball. If balls =
 * [G, B, G, G, R, B, R, G], then input should be:
 * <p>
 * 8
 * <p>
 * G
 * <p>
 * B
 * <p>
 * G
 * <p>
 * G
 * <p>
 * R
 * <p>
 * B
 * <p>
 * R
 * <p>
 * G
 * <p>
 * <p>
 * <p>
 * Output Format: There will be n lines of output. i-th line contains a character balls[i], denoting character at index
 * i of balls. Here, balls is the character array after the function that you are going to complete is called. For input
 * balls = [G, B, G, G, R, B, R, G], output will be:
 * <p>
 * R
 * <p>
 * R
 * <p>
 * G
 * <p>
 * G
 * <p>
 * G
 * <p>
 * G
 * <p>
 * B
 * <p>
 * B
 */
public class DutchNationalFlag {

    public static void dutch_flag_sortON(char[] balls) {

        int start = 0;
        int end = balls.length - 1;
        int index = 0;

        while (start < end && index <= end) {

            if (balls[index] == 'R') {
                balls[index] = balls[start];
                balls[start] = 'R';
                start++;
                index++;
            } else if (balls[index] == 'B') {
                balls[index] = balls[end];
                balls[end] = 'B';
                end--;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] s) throws IOException {

        char[] ch = { 'B', 'R', 'G', 'G', 'R', 'B', 'G', 'R' };

        dutch_flag_sortON(ch);
        System.out.println(new String(ch));
    }

    /**
     *
     * As mentioned in the notes: A naive solution to this problem, is to simply count how many balls of each color,
     * and then overwrite the array with that many balls in the expected order of colors. This is not the solution we
     * (and an interviewer would) look for here.
     *
     *
     *
     * To solve the problem, taking one example will help. Try to play with:
     *
     * [R, G, G, R, G, B, G, B, R, R, R, G]
     *
     * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
     *
     *
     *
     * Suppose our initial array is: [array to process]
     *
     * ----
     *
     * Now "suppose" after processing some part of the given array, we are able to maintain its structure like:
     *
     * [R, R, ..., R, R][G, G, ..., G, G][remaining array to process][B, B, ..., B, B]
     *
     *
     *
     * Just assume that we are able to maintain this structure somehow, currently do not worry about how!
     *
     * ----
     *
     * If we can maintain the same structure after processing the first ball of "remaining array to process" in O(1)
     * time, then it means now we have to solve the same problem with the reduced size of "remaining array to process".
     *
     *
     *
     * After we have processed the first ball, we repeat the process for the next ball; that also takes O(1) time and
     * maintains the same structure! So at the end we will be able to maintain the same structure and that will be
     * the sorted array! We are taking O(1) time to process each character hence the time complexity will also be n *
     * O(1) that is O(n)! Let's think how can we maintain the same structure when first letter in the "remaining
     * array to process" is:
     *
     * ----
     *
     * 'R', which means array is:
     *
     * [R, R, ..., R, R]['G', G, ..., G, G]['R' + other remaining array to process][B, B, ..., B, B]
     *
     *
     *
     * What should we do with 'R' to maintain the same structure? Swapping it with the leftmost 'G'?
     *
     *
     *
     * Yes, that is possible and that will maintain the structure with only one swap, "assuming that we have the
     * index of the leftmost G".
     *
     * So now our array will look like:
     *
     * [R, R, ..., R, R, 'R'][G, ..., G, G, 'G'][other remaining array to process][B, B, ..., B, B]
     *
     * ----
     *
     * 'G' which means array is:
     *
     * [R, R, ..., R, R][G, G, ..., G, G]['G' + other remaining array to process][B, B, ..., B, B]
     *
     *
     *
     * What should we do with 'G' to maintain the same structure?
     *
     * Nothing to do, just go to the next character!
     *
     *
     *
     * So now our array will look like:
     *
     * [R, R, ..., R, R][G, G, ..., G, G, 'G'][other remaining array to process][B, B, ..., B, B]
     *
     * ----
     *
     * 'B' which means array is:
     *
     * [R, R, ..., R, R][G, G, ..., G, G]['B' + other remaining array to process + 'last character'][B, B, ..., B, B]
     *
     *
     *
     * What should we do with 'B' to maintain the same structure?
     *
     * Swap 'B' with the 'last character' of the "remaining array to process"!  Yes that is possible and that will
     * maintain the structure with only one swap "assuming that we have the index of last character". So now our
     * array will look like:
     *
     * [R, R, ..., R, R][G, G, ..., G, G]['last character' + other remaining array to process]['B', B, B, ..., B, B]
     *
     * ----
     *
     * We made some assumptions:
     *
     *
     *
     * 1) When the first character is 'R', we assumed that "we have the index of the leftmost G".
     *
     * 2) When the first character is 'B', we assumed that "we have the index of the last character".
     *
     *
     *
     * So somehow we need to maintain these two indices and we will be able to solve the problem by following the
     * steps above.
     *
     * Also when we are starting we can take,
     *
     * [R, R, ..., R, R], [G, G, ..., G, G] and [B, B, ..., B, B] parts = "". And then start our solution!
     *
     *
     *
     * The idea sounds complex but the code can be very simple!
     *
     *
     *
     * Time Complexity:
     *
     * O(n).
     *
     *
     *
     * Auxiliary Space Used:
     *
     * O(1) as we are using only constant extra space.
     *
     *
     *
     * Space Complexity:
     *
     * O(n).
     */

}

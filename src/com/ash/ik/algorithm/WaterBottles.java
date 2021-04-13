package com.ash.ik.algorithm;

/**
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 *
 * The operation of drinking a full water bottle turns it into an empty bottle.
 *
 * Return the maximum number of water bottles you can drink.
 *
 * Input: numBottles = 9, numExchange = 3
 * Output: 13
 * Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 9 + 3 + 1 = 13.
 *
 *
 * Input: numBottles = 15, numExchange = 4
 * Output: 19
 * Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 15 + 3 + 1 = 19.
 *
 */
public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {

        int total = numBottles;

        while (numBottles >= numExchange) {
            total += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }

        return total;
    }

    public static void main(String[] args) {

        WaterBottles o = new WaterBottles();
        o.numWaterBottles(9, 3);
    }
}

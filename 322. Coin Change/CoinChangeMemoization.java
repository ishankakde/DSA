/*

leet code problem 322
    - level : medium
    - Coin Change
    - https://leetcode.com/problems/coin-change

You are given an integer array coins representing coins of different denominations and
an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

 */

package com.dsa.lc;

import java.util.Arrays;

public class CoinChangeMemoization {

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);

    }

    private int coinChange(int[] coins, int amount, int[] cache) {

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (cache[amount - 1] != 0) {
            return cache[amount - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = coinChange(coins, amount - coin, cache);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }

        cache[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return cache[amount - 1];
    }
}

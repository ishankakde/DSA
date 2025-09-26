/*

leet code problem 121
    - Level - easy
    - Best Time to Buy and Sell Stock
    - https://leetcode.com/problems/best-time-to-buy-and-sell-stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

logic -
create two variables to track minimum and max difference (profit) , initialize them as of day 1  -
   1. minSoFar with price for that day which is price[0]
   2. maxDiff = 0 , as we have not yet seen prices for other days.

   If the next day price goes down then update minSoFar with new lower price.
   If price goes up then calculate new maxDiff.

 */

package com.dsa.lc;

public class BuySellStock {
    public int maxProfit(int[] prices) {

        int minSoFar = prices[0]; // price on day 1
        int maxDiff = 0;             // diff 0 because don't know price of next day yet

        for(int i=0; i < prices.length; i++){
            if(prices[i] < minSoFar){ // if price goes down next day then set new minSoFar
                minSoFar = prices[i];
            }else{  // if price goes up then calculate new maxDiff.
                maxDiff = Math.max(maxDiff, prices[i] - minSoFar);
            }
        }
        return maxDiff;
    }
}

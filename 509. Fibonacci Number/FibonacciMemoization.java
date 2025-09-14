/*

leet code problem 509
    - level : easy
    - Fibonacci Number
    - https://leetcode.com/problems/fibonacci-number

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number
is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */

package com.dsa.lc;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {

    Map<Integer, Integer> cacheMap = new HashMap<>();  // An Integer[] cache = new Integer[100] can be used instead of map but its length is unknown
    
    public int fib(int n) {

        //base condition
        if(n == 0 || n== 1){
            return n;
        }

        if(cacheMap.containsKey(n)){
            return cacheMap.get(n);
        }

        int result =  fib(n - 1) + fib(n - 2);
        cacheMap.put(n, result);
        return result;
    }
}

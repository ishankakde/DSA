/*

leet code problem 647
    - Level - medium
    - Palindromic Substring
    - https://leetcode.com/problems/palindromic-substrings

Given a string s, return the number of palindromic substrings in it.
A string is palindromic if it reads the same forward and backward.
A substring is a contiguous non-empty sequence of characters within a string.

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Logic -
Approach - Expand Through Center

A palindrome can be of odd or even length.
an odd length palindrome has a single mid/center ex. racecar -> rac 'e' car
an even length palindrome has two mid/center ex. hannah -> ha 'nn' ah
The code iterates through each character of string, treating each character as a mid of the potential palindrome.
As the potential palindrome can be of even/odd length, we look up for both even and odd length palindromes.
The helper method expandOutwardThroughCenter expands outwards from the center "while" the characters on both ends match.
It adds up all such palindromic substrings found through this expansion process.
Finally, it returns the total count of all palindromic substrings in the string.

Time complexity - O(n^2)

 */
package com.dsa.lc;

public class PalindromicSubString {

    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddCount = expandOutwardThroughCenter(s, i, i);
            int evenCount = expandOutwardThroughCenter(s, i, i + 1);
            totalCount = totalCount + oddCount + evenCount;
        }
        return totalCount;
    }

    private int expandOutwardThroughCenter(String s, int mid1, int mid2) {
        int left = mid1;
        int right = mid2;
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
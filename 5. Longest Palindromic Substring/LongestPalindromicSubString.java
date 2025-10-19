/*

leet code problem 5
    - Level - medium
    - Longest Palindromic Substring
    - https://leetcode.com/problems/longest-palindromic-substring

Given a string s, return the longest palindromic substring in s.

definititons -
palindromic - A string is palindromic if it reads the same forward and backward.
substring   - A substring is a contiguous non-empty sequence of characters within a string.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Logic -
Approach - Expand Through Center

A palindrome can be of odd or even length.
an odd length palindrome has a single mid/center ex. racecar -> rac 'e' car
an even length palindrome has two mid/center ex. hannah -> ha 'nn' ah

As we are searching a palindromic substring, a palindrome could be of an even (2-mid) or odd (1-mid) length.

The code iterates through each character of string, treating each character as a mid of the potential palindrome.
As the potential palindrome can be of even/odd length, we look up for both even and odd length palindromes.

At each character/iteration, we find the length (right - left - 1) potential even or odd length palindrome,
using expandOutwardThroughCenter().
why length = right - left - 1 ?
because left and right have moved one step too far — they now point just outside the palindrome.
Then find max length of the current even/odd palindromes.

Then we compare it with the length of the longest one found so far, using below condition -
if(maxPalindromeLength > (end - start))
here, we are comparing the length of current iteration palindrome with longest found so far.
here (end - start) pointers defines the max palindrome found so far.
hence the check to compare if current iteration palindrome is longer than the max so far.
If longer, then update start and end index.

Below two are the formulas for find the start and end index of the palindrome,
when you know just length of palindrome and current iteration index.

start = i - (maxPalindromeLength - 1)/2;
end   = i +  maxPalindromeLength / 2;

Once all iterations are complete, return the longest palindromic substring using the index.
return s.substring(start, end + 1); why add 1 because sub string does not include end index hence end+1

Time complexity - O(n^2)

 */
package com.dsa.lc;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {

        // indexes of the found palindrome.
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            int palindromeOddLength  = expandOutwardThroughCenter(s, i, i);
            int palindromeEvenLength = expandOutwardThroughCenter(s, i, i + 1);

            int maxPalindromeLength = Math.max(palindromeOddLength, palindromeEvenLength);

            //based of the length of palindrome found and value of i, find & update start and end pointer.
            if(maxPalindromeLength > (end - start)){
                start = i - (maxPalindromeLength - 1) / 2;
                end   = i +  maxPalindromeLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandOutwardThroughCenter(String s, int mid1, int mid2){
        int left = mid1;
        int right = mid2;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
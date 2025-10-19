/*

leet code problem 125
    - Level - easy
    - Valid Palindrome
    - https://leetcode.com/problems/valid-palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Logic -
Uses two pointer approach
validate for any non-alphanumeric character and skip them by start++ or end --
use continue keyword to re-eavaluate while loop condition after each skip.
Lowercase the character before compare.
At anypoint if start and end characters do not match return false.
If loops gets complete means string is a valid palindrome, return true.

 */
package com.dsa.lc;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end){

            char startChar = s.charAt(start);
            if(!Character.isLetterOrDigit(startChar)){
                start++;
                continue;
            }

            char endChar = s.charAt(end);
            if(!Character.isLetterOrDigit(endChar)){
                end--;
                continue;
            }

            if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
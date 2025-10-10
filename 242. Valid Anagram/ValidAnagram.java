/*

leet code problem 242
    - Level - easy
    - Valid Anagram
    - https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram ( An anagram is a word or phrase formed
by rearranging the letters of a different word or phrase, using all the original letters exactly
once. ) of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Logic -

This code checks if two strings s and t are anagrams by comparing character frequencies.
ASCII characters are used to map each character to array index.
It uses a fixed-size array arr[26] to count each letter's occurrence in s (increment) and t (decrement).
If both strings are anagrams, all values in the array should return to zero.
The final loop verifies that — if any count is non-zero, the strings are not anagrams.

The array indexes are mapped to character using ASCII code, shown below -
ASCII codes -
    lowercase a - 97
    lowercase b - 98
    lowercase c - 99
     .
     .
    lowercase x - 120
    lowercase y - 121
    lowercase z - 122

By subtracting ASCII value of 'a' from each ASCII value of a character in anagram corresponds to an index in an array.

    a = (a - a) = ( 97 - 97 ) = index 0
    b = (b - a) = ( 98 - 97 ) = index 1
    c = (c - a) = ( 99 - 97 ) = index 2
    .
    .
    x = (x - a) = (120 - 97) = index 23
    y = (y - a) = (121 - 97) = index 24
    z = (z - a) = (122 - 97) = index 25

 */
package com.dsa.lc;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] arr = new int[26];

        //increment loop
        for(int i = 0; i < s.length(); i++){
            char schar = s.charAt(i);
            int index = schar - 'a';
            arr[index] = arr[index] + 1;
        }

        //decrement loop
        for(int i = 0; i < t.length(); i++){
            char tchar = t.charAt(i);
            int index = tchar - 'a';
            arr[index] = arr[index] - 1;
        }

        for(int count : arr){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}

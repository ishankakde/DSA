/*

leet code problem 3
    - Level - medium
    - Longest substring without repeating characters
    - https://leetcode.com/problems/longest-substring-without-repeating-characters

Given a string s, find the length of the longest substring (A substring is a contiguous non-empty
sequence of characters within a string.) without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Logic -

Approach - Sliding window with hash set to track the characters seen so far.

The while loop handles duplicates by shrinking the sliding window from the left/start.
If the current character already exists in the set, it keeps removing characters from the
start (start pointer) until the duplicate is gone, ensuring all characters in the window remain unique.

While calculating maxLength +1 is added because (end - start) gives the number of characters between the two indices,
but since both start and end are inclusive in the substring, we add 1 to get the correct length.
ex. a,b,c -> when start and end point to index 0, the substring 'a' is of length 1,
hence 1 is added - (end - start + 1) --> (0 - 0 + 1) = 1

Time complexity - O(n)
 */
package com.dsa.lc;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int start = 0;

        Set<Character> set = new HashSet<>();

        for(int end = 0; end < s.length(); end++){

            char currentChar = s.charAt(end);

            while(set.contains(currentChar)){
                set.remove(s.charAt(start));
                start++;
            }

            set.add(currentChar);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}

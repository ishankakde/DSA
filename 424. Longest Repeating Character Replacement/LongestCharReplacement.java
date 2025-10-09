/*

leet code problem 424
    - Level - medium
    - Longest Repeating Character Replacement
    - https://leetcode.com/problems/longest-repeating-character-replacement

You are given a string s and an integer k. You can choose any character of the string and change it to
any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

Logic -

Approach - Sliding window with hash map.
HashMap is used to store <char, count> as <key, value> pair.

If the number of characters that need to be replaced (i.e., windowLength - maxCount) exceeds k,
the window is shrunk from the left (start++) to maintain a valid state.

Each iteration keep track of maximum window size (maxWindowLength) seen so far.
Time complexity - O(n)
 */
package com.dsa.lc;

class LongestCharReplacement {
    public int characterReplacement(String s, int k) {

        int start = 0;
        int maxWindowLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;

        for(int end = 0; end < s.length(); end++){

            //fetch and update map
            char key = s.charAt(end);
            int count = map.getOrDefault(key, 0);
            count ++;
            map.put(key, count);

            maxCount = Math.max(maxCount, count);
            int windowLength = end - start + 1;

            /* validate if no. of replacements required are less than allowed replacements (k),
            if greater, then update map by reducing the count of char at start,
            move the start pointer to next character & reduce the windowLength by 1 */

            if(windowLength - maxCount > k){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start ++;
                windowLength --;
            }

            maxWindowLength = Math.max(maxWindowLength, windowLength);
        }
        return maxWindowLength;
    }
}

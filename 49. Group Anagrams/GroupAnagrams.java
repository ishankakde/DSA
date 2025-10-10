/*

leet code problem 49
    - Level - medium
    - Group Anagrams
    - https://leetcode.com/problems/group-anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Logic -

create a hash for each word such that all valid anagrams have the same hash.
create a map to store hash and its list of matching anagrams. Return the list of lists.

How to create hash ?
By using ASCII code and an array, below are ASCII code
    lowercase a - 97
    lowercase b - 98
    lowercase c - 99
     .
     .
    lowercase x - 120
    lowercase y - 121
    lowercase z - 122

Total no. of alphabets are 26 and that is why array is of length 26.
By subtracting ASCII value of 'a' from each ASCII value of a character in anagram corresponds to an index in an array.

    a = (a - a) = ( 97 - 97 ) = index 0
    b = (b - a) = ( 98 - 97 ) = index 1
    c = (c - a) = ( 99 - 97 ) = index 2
    .
    .
    x = (x - a) = (120 - 97) = index 23
    y = (y - a) = (121 - 97) = index 24
    z = (z - a) = (122 - 97) = index 25

below are the hash values of few example strings, array value is incremented for each repeated character -
"aabbbcpqrxyz"  hash will be - [2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1]
"aaaaaaaaaaab"  hash will be - [11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
"bbbbbbbbbba"   hash will be - [1, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

After converting array values to String
"abcdefpqrxyz" - 2310000000000011100000111
"aaaaaaaaaaab" - 11100000000000000000000000
"aaaaaaaaaaab" - 11100000000000000000000000

but the hash value for "aaaaaaaaaaab" & "bbbbbbbbbba" is same and not unique (hash collision).
Therefore to make a unique hash append '#' after each element in array -

"aaaaaaaaaaab" - #11#1#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0
"aaaaaaaaaaab" - #1#11#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0

 */
package com.dsa.lc;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List> map = new HashMap<>();

        for(String word : strs){

            //create hash array
            int[] hash = new int[26];
            for(char c : word.toCharArray()){
                int index = c -'a';
                hash[index]++;
            }

            //create unique hash string
            StringBuilder sb = new StringBuilder();
            for(int i : hash){
                sb.append("#");
                sb.append(i);
            }
            String hashKey = sb.toString();

            // populate map
            if(map.containsKey(hashKey)){
                List list = map.get(hashKey);
                list.add(word);
            }else{
                List list = new ArrayList();
                list.add(word);
                map.put(hashKey, list);
            }
        }
        return new ArrayList(map.values());
    }
}

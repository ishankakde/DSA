/*

leet code problem 271
    - Level - medium
    - Encode and Decode Strings
    - https://leetcode.com/problems/encode-and-decode-strings

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network
and is decoded back to the original list of strings.

Machine 1 (sender) has the function:
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}

Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}

So Machine 1 does:
string encoded_string = encode(strs);
and Machine 2 does:
vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.
You are not allowed to solve the problem using any serialize methods (such as eval).

Example 1:
Input: dummy_input = ["Hello","World"]
Output: ["Hello","World"]
Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);

Example 2:
Input: dummy_input = [""]
Output: [""]

Follow up: Could you write a generalized algorithm to work on any possible set of characters?

Logic -

Encoding Format -> [lenght][delimiter][word]
example - ["Hello", "World"] -> 4#Hello5#World
Delimiter # tells the start for next word.
The length before tells how many characters to read for the word.
Without length before delimiter, you would not know where the word ends, specially if the word contains a delimiter.
example - ["Hello", "Wor#ld"] -> 4#Hello6#Wor#ld.

Time complexity - O(n)

 */
package com.dsa.lc;

public class EncodeDecode {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> output = new ArrayList<>();

        int i = 0;
        while(i < s.length()){
            int delimiterIndex = s.indexOf('#',i); //search delimiter '#" from a specific index i
            int wordLength = Integer.valueOf(s.substring(i,delimiterIndex));
            i = delimiterIndex + wordLength + 1; // increment i to next length index
            String word = s.substring(delimiterIndex + 1, i);
            output.add(word);
        }
        return output;
    }
}

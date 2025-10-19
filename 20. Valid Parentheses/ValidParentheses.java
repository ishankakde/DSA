/*

leet code problem 20
    - Level - easy
    - Valid Paranthesis
    - https://leetcode.com/problems/valid-parentheses/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Logic -

This program checks if a string of brackets (like ()[]{}) is properly balanced.
It uses a stack to keep track of opening brackets. For each closing bracket, it checks if the top of the stack
has the matching opening bracket — if not, it's invalid. If the stack is empty before matching or has leftover
brackets after processing, the string is invalid. In the end, a valid string will leave the stack empty.

 */
package com.dsa.lc;

public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char currBracket = s.charAt(i);
            if(currBracket == '[' || currBracket == '{' || currBracket == '('){
                stack.push(currBracket); // add opening bracket
            }else{
                if(stack.isEmpty()){ // if first element itself is closing bracket
                    return false;
                }
                char top = stack.peek();
                if(top == '[' && currBracket == ']' ||
                        top == '{' && currBracket == '}' ||
                        top == '(' && currBracket == ')'){
                    stack.pop(); // remove if matching closing bracket exist.
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
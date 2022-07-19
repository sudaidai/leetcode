package com.company;

/*
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */

import com.company.data.Stack;

public class Lc20 implements Answer{
    @Override
    public int getIndex() {
        return 20;
    }

    @Override
    public String getRoute() {
        return "valid-parentheses";
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatch(stack.pop(), currentChar)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isMatch(Character open, Character close) {
        if (open == '(' && close != ')') {
            return false;
        }
        if (open == '[' && close != ']') {
            return false;
        }
        if (open == '{' && close != '}') {
            return false;
        }
        return true;
    }
}

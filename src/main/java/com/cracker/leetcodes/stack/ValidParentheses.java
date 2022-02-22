package com.cracker.leetcodes.stack;

/**
 * This is Leetcode number 20: Valid parentheses.
 */
public class ValidParentheses {

    public boolean isValid(final String s) {
        Stack stack = new Stack();
        char[] str = s.toCharArray();
        if (str.length <= 1 || str.length % 2 == 1) {
            return false;
        }
        for (char c : str) {
            if (stack.temp >= 0) {
                switch (c) {
                    case ')':
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            return false;
                        }
                        break;
                    default:
                        stack.push(c);
                        break;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.temp == -1;
    }

    static class Stack {
        private char[] items = new char[10];

        private int temp = -1;

        public void push(final char element) {
            if (temp >= items.length - 1) {
                char[] tempStack = new char[items.length << 1];
                System.arraycopy(items, 0, tempStack, 0, items.length);
                items = tempStack;
            }
            temp++;
            items[temp] = element;
        }

        public char pop() {
            char element;
            if (temp >= 0) {
                element = items[temp];
                items[temp] = 0;
                temp--;
            } else {
                throw new RuntimeException("This stack is Empty!!!");
            }
            return element;
        }
    }

//    public boolean isValid(final String s) {
//        if(s.length() % 2 == 0) {
//            int length = s.length() / 2;
//            for(int i = 0; i < length; i++) {
//                s = s.replace("()", "").replace("[]", "").replace("{}", "");
//            }
//            return s.length() == 0;
//        }
//        return false;
//    }
}

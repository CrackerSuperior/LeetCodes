package com.cracker.leetcodes.string;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 6: Zigzag transformation.
 */
public class ZigzagTransformation {
    
    public String convert(final String s, final int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> builders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            builders.add(new StringBuilder());
        }
        int index = 0;
        int flag = 1;
        for (char c : s.toCharArray()) {
            builders.get(index).append(c);
            index += flag;
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : builders) {
            result.append(builder);
        }
        return result.toString();
    }
}

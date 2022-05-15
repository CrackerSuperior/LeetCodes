package com.cracker.leetcodes.array;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 1352: Product of the Last K Numbers.
 */
public class ProductOfTheLastKNumbers {

    class ProductOfNumbers {

        private List<Integer> result = new ArrayList<>();

        ProductOfNumbers() {
            result.add(1);
        }

        public void add(final int num) {
            if (num == 0) {
                result.clear();
                result.add(1);
                return;
            }
            result.add(result.get(result.size() - 1) * num);
        }

        public int getProduct(final int k) {
            int size = result.size();
            if (k > size - 1) {
                return 0;
            }
            return result.get(size - 1) / result.get(size - k - 1);
        }
    }

}

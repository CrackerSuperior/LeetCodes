package com.cracker.leetcodes.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is Leetcode number 1276: Number of Burgers with No Waste of Ingredients.
 */
public class NumberOfBurgersWithNoWasteOfIngredients {

    public List<Integer> numOfBurgers(final int tomatoSlices, final int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices / 2 - cheeseSlices < 0 || 2 * cheeseSlices - tomatoSlices / 2 < 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(tomatoSlices / 2 - cheeseSlices, 2 * cheeseSlices - tomatoSlices / 2);
    }
}

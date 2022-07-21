package com.cracker.leetcodes.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode number 341: Flatten Nested List Iterator.
 */
public class FlattenNestedListIterator {

    public static class NestedIterator implements Iterator<Integer> {

        private LinkedList<NestedInteger> list;

        public NestedIterator(final List<NestedInteger> nestedList) {
            list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!list.isEmpty() && !list.getFirst().isInteger()) {
                List<NestedInteger> first = list.remove(0).getList();
                for (int i = first.size() - 1; i >= 0; i--) {
                    list.addFirst(first.get(i));
                }
            }
            return !list.isEmpty();
        }
    }

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}

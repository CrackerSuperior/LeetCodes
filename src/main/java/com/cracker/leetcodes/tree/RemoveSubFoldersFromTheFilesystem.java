package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is Leetcode number 1233: Remove Sub-Folders from the Filesystem.
 */
public class RemoveSubFoldersFromTheFilesystem {

    public List<String> removeSubfolders(final String[] folder) {
        Trie trie = new Trie();
        for (int i = 0; i < folder.length; i++) {
            trie.insert(i, folder[i]);
        }
        List<String> result = new ArrayList<>();
        for (Integer search : trie.search()) {
            result.add(folder[search]);
        }
        return result;
    }

    static class Trie {

        private final Map<String, Trie> children = new HashMap<>();

        private int fid = -1;

        public void insert(final int fid, final String folder) {
            Trie node = this;
            String[] split = folder.split("/");
            for (int i = 1; i < split.length; ++i) {
                String key = split[i];
                if (!node.children.containsKey(key)) {
                    node.children.put(key, new Trie());
                }
                node = node.children.get(key);
            }
            node.fid = fid;
        }

        public List<Integer> search() {
            List<Integer> ans = new ArrayList<>();
            dfs(this, ans);
            return ans;
        }

        private void dfs(final Trie node, final List<Integer> ans) {
            if (node.fid != -1) {
                ans.add(node.fid);
                return;
            }
            for (Trie value : node.children.values()) {
                dfs(value, ans);
            }
        }
    }
}

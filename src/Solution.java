import common.problem.solving.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The class {@code Solution} is a container of leetcode solution, you can find solutions for many problems.
 *
 * @author Karthikeyan T
 */
public class Solution {

    /**
     * <a href="https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements">
     *   2593. Find Score of an Array After Marking All Elements
     * </a>
     */
    public long findScore(int[] nums) {
        boolean[] markedElts = new boolean[nums.length];
        int markedCount = 0;
        int result = 0;
        PriorityQueue<Map.Entry<Integer, Integer>> q = IntStream.range(0, nums.length).mapToObj(index -> Map.entry(nums[index], index))
                .collect(Collectors.toCollection(() -> new PriorityQueue<>((a, b) -> {
                    if (Objects.equals(a.getKey(), b.getKey())) {
                        return a.getValue() - b.getValue();
                    }
                    return a.getKey() - b.getKey();
                })));

        while (markedCount < nums.length) {
            Map.Entry<Integer, Integer> min = q.poll();
            int index = min.getValue();
            if (!markedElts[index]) {
                result += min.getKey();
                markedCount++;
                markedElts[index] = true;
                if (index > 0 && !markedElts[index - 1]) {
                    markedElts[index - 1] = true;
                    markedCount++;
                }
                if (index < nums.length - 1 && !markedElts[index + 1]) {
                    markedElts[index + 1] = true;
                    markedCount++;
                }
            }
        }
        return result;
    }

    /**
     * <a href="https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i">
     *  3264. Final Array State After K Multiplication Operations I
     * </a>
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> q = IntStream.range(0, nums.length).mapToObj(index -> new int[]{nums[index], index})
                .collect(Collectors.toCollection(() -> new PriorityQueue<>((a, b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                })));

        while (k-- > 0) {
            int[] min = q.poll();
            if (min != null) {
                nums[min[1]] = min[0] *= multiplier;
                q.add(min);
            }
        }
        return nums;
    }

    /**
     * <a href="https://leetcode.com/problems/two-sum/">
     *  1. Two Sum
     * </a>
     */
     public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (index.containsKey(target - nums[i])){
                return new int[]{index.get(target - nums[i]), i};
            }
            index.put(nums[i], i);
        }
        return null;
    }

    /**
     * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">
     *  114. Flatten Binary Tree to Linked List
     * </a>
     */
    public void flatten(TreeNode root) {
         getFlatten(root);
    }

    // actual function solves the problem
    private TreeNode getFlatten(TreeNode root) {
         if (root == null) {
             return null;
         }
         TreeNode x = getFlatten(root.left);
         TreeNode y = getFlatten(root.right);
         if (x != null) {
             x.right = root.right;
             root.right = root.left;
         }
         root.left = null;
         return y == null ? x == null ? root : x : y;
    }

    /**
     * <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str1 = new String(chars);
            List<String> ls = result.getOrDefault(str1, new ArrayList<>());
            ls.add(str);
            result.put(str1, ls);
        }
        return new ArrayList<>(result.values());
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/">
     *  1422. Maximum Score After Splitting a String
     * </a>
     */
    public int maxScore(String s) {
        int ones = (int) s.chars().filter(c -> c == '1').count();
        if (ones == 0) {
            return s.length() - 1;
        }

        int zeroes = 0, score = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '1') {
                --ones;
            }
            else {
                ++zeroes;
            }
            score = Math.max(ones + zeroes, score);
        }
        return score;
    }

    /**
     * <a href="https://leetcode.com/problems/string-matching-in-an-array/">1408. String Matching in an Array</a>
     */
    public List<String> stringMatching(String[] words) {
        return Arrays.stream(words).filter(word -> {
            for (String s : words) {
                if (s.length() != word.length() && s.contains(word)) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }

    /**
     *
     */
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    ++count;
                }
            }
        }
        return count;
    }

    /**
     * <a href="https://leetcode.com/problems/invert-binary-tree">226. Invert Binary Tree</a>
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    /**
     * <a href="https://leetcode.com/problems/majority-element">169. Majority Element</a>
     */
    public int majorityElement(int[] nums) {
        int canditate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                canditate = num;
            }
            count += canditate == num ? 1 : -1;
        }
        return canditate;
    }
}
import common.problem.solving.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
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
                min[0] *= multiplier;
                nums[min[1]] *= multiplier;
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
        for (int i = 0; i < nums.length; i++) {
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
}
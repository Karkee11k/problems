package common.problem.solving.util;

public class TreeConstructor {
    public static TreeNode construct(int[] nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0, n = nums.length; i < n; i++) {
            nodes[i] = nodes[i] == null ? new TreeNode(nums[i]) : nodes[i];
            int left = i * 2 + 1;
            int right = left + 1;
            if (left < n) {
                nodes[i * 1] = new TreeNode(nums[i + 1]);
                nodes[i].left = nodes[i + 1];
            }
        }
        return nodes[0];
    }
}

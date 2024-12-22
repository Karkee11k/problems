package common.problem.solving.util;

/**
 * The class {@code TreeNode} represents a node in a tree. Use it for tree construction.
 *
 * @author Karthikeyan T
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) { this.val = val; }

    @Override
    public String toString() {
        return "TreeNode(" + val + ")";
    }
}
package common.problem.solving.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeConstructor {
    public static enum Order { PREORDER, INORDER, POSTORDER, LEVEL_ORDER; }

    /**
     * Contructs the tree in the given order
     * @param nums nodes in the tree
     * @param order order to constructs
     * @return returns the root
     */
    public static TreeNode construct(Integer[] nums, Order order) {
        if (order == Order.LEVEL_ORDER) {
            return constructBfs(nums);
        }
        return constructPreorder(nums);
    }

    private  static TreeNode constructBfs(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < nums.length; i++) {
            TreeNode node = q.poll();
            if (nums[i] != null) {
                node.left = new TreeNode(nums[i]);
                q.add(node.left);
            }
            if (++i < nums.length && nums[i] != null) {
                node.right = new TreeNode(nums[i]);
                q.add(node.right);
            }
        }
        return root;
    }

    private static TreeNode constructPreorder(Integer[] nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        nodes[0] = new TreeNode(nums[0]);
        for (int i = 0, n = nums.length; i * 2 + 1 < n; i++) {
            if (nums[i] == null || nodes[i] == null) {
                continue;
            }
            int first = i * 2 + 1;
            nodes[first] = nums[first] != null ? new TreeNode(nums[first]) : null;
            nodes[i].left = nodes[first];
            if (++first < n) {
                nodes[first] = nums[first] != null ? new TreeNode(nums[first]) : null;
                nodes[i].right = nodes[first];
            }
        }
        return nodes[0];
    }

    /**
     * Adds the nodes of the given tree in preorder
     * @param root root of the tree
     * @param nodes list to add the nodes
     */
    public static void addTreeNodes(TreeNode root, List<TreeNode> nodes) {
        preorder(root, nodes);
    }

    /**
     * Adds the nodes of the given tree in the given order
     * @param root root of the tree
     * @param nodes list to add the nodes
     * @param order order to collect the nodes
     */
    public static void addTreeNodes(TreeNode root, List<TreeNode> nodes, Order order) {
        if (order == Order.PREORDER) {
            preorder(root, nodes);
        }
        else if (order == Order.INORDER) {
            inorder(root, nodes);
        }
        else if (order == Order.LEVEL_ORDER) {
            bfs(root, nodes);
        }
        else {
            postorder(root, nodes);
        }
    }

    // collects the nodes in level order
    private static void bfs(TreeNode root, List<TreeNode> nodes) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            nodes.add(node);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

   // collects the nodes in inorder
   private static void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root != null) {
            inorder(root.left, nodes);
            nodes.add(root);
            inorder(root.right, nodes);
        }
    }

    // collects the nodes in preorder
    private static void preorder(TreeNode root, List<TreeNode> nodes) {
        if (root != null) {
            nodes.add(root);
            preorder(root.left, nodes);
            preorder(root.right, nodes);
        }
    }

    // collects the nodes in postorder
    private static void postorder(TreeNode root, List<TreeNode> nodes) {
        if (root != null) {
            postorder(root.left, nodes);
            postorder(root.right, nodes);
            nodes.add(root);
        }
    }
}

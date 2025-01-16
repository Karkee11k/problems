import common.problem.solving.util.TreeConstructor;
import common.problem.solving.util.TreeNode;
import common.problem.solving.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point to test solutions. Add a static method to implement your solution
 * and call it from main. Each method should be self-contained for modular testing.
 */
public class Main {
    private static final Solution solution = new Solution();

    // main function, here you can try solutions
    public static void main(String[] args) throws Exception {
        solveGetFinalState();
        solveFindScore();
        solveTwoSum();
        solveFlattenTree();
        solveGroupAnagrams();
        solveMaxScore();
        solveStringMatching();
        solveCountPrefixSuffixPairs();
        solveInvertTree();
        solveMajorityElement();
    }

    static void solveFlattenTree() {
        Integer[] nums = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = TreeConstructor.construct(nums, TreeConstructor.Order.LEVEL_ORDER);
        solution.flatten(root);
        List<TreeNode> nodes = new ArrayList<>();
        TreeConstructor.addTreeNodes(root, nodes);
        Utils.printAns(nodes);
    }

    static void solveGetFinalState() {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        Utils.printAns(solution.getFinalState(nums, k, multiplier));
    }

    static void solveFindScore() throws IOException {
        int[] nums = Utils.readIntArray("inputs/find_score_input.txt", ",", true);
        Utils.printAns(solution.findScore(nums));
    }

    static void solveTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Utils.printAns(solution.twoSum(nums, target));
    }

    static void solveGroupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Utils.printAns(solution.groupAnagrams(strs));
    }

    static void solveMaxScore() {
        Utils.printAns(solution.maxScore("011101"));
    }

    static void solveStringMatching() {
        String[] words = {"mass", "as", "hero", "superhero"};
        Utils.printAns(solution.stringMatching(words));
    }

    static void solveCountPrefixSuffixPairs() {
        String[] words = {"a", "aba", "ababa", "aa"};
        Utils.printAns(solution.countPrefixSuffixPairs(words));
    }

    static void solveInvertTree() {
        Integer[] arr = {2, 1, null};//{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeConstructor.construct(arr, TreeConstructor.Order.LEVEL_ORDER);
        List<TreeNode> ans = new ArrayList<>();
        solution.invertTree(root);
        TreeConstructor.addTreeNodes(root, ans, TreeConstructor.Order.LEVEL_ORDER);
        Utils.printAns(ans);
    }

    static void solveMajorityElement() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Utils.printAns(solution.majorityElement(nums));
    }
}

import common.problem.solving.util.ListCreator;
import common.problem.solving.util.TreeConstructor;
import common.problem.solving.util.TreeNode;
import common.problem.solving.util.Utils;
import jdk.jshell.execution.Util;

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
        // solveGetFinalState();
        // solveFindScore();
        // solveTwoSum();
        // solveFlattenTree();
        // solveGroupAnagrams();
        // solveMaxScore();
        // solveStringMatching();
        // solveCountPrefixSuffixPairs();
        // solveInvertTree();
        // solveMajorityElement();
        // solveNumOfSubarrays();
        // solveHasIncreasingSubarrays();
//        solveCopyRandomList();
        solveHIndex();
        
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

    static void solveNumOfSubarrays() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Utils.printAns(solution.numOfSubarrays(nums));
    }
    
    static void solveHasIncreasingSubarrays() {
        var nums = List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
        int k = 3;
        var nums2 = List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
        var k2 = 5;
        var nums3 = List.of(-15, 19);
        var k3 = 1;
        Utils.printAns(solution.hasIncreasingSubarrays(nums, k));
        Utils.printAns(solution.hasIncreasingSubarrays(nums2, k2));
        Utils.printAns(solution.hasIncreasingSubarrays(nums3, k3));
        
    }
    
    static void solveCopyRandomList() {
        Integer[][] input = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        ListCreator.Node head = ListCreator.createRandomPointerList(input);
        ListCreator.printList(head);
        ListCreator.printList(solution.copyRandomList(head));
    }
    
    static void solveHIndex() {
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations1 = {1, 3, 1};
        int[] citations2 = {0,2,1000};
        Utils.printAns(solution.hIndex(citations2));
    }
}
import common.problem.solving.util.Utils;

import java.io.IOException;

/**
 * Class to call solutions. Create a static method to run your solution.
 */
public class Main {
    private static final Solution solution = new Solution();

    // main function, here you can try solutions
    public static void main(String[] args) throws Exception {
        solveGetFinalState();
        solveFindScore();
        solveTwoSum();
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
}

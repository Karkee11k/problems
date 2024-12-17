import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Class to call solutions. Create a static method for run your solution
 */
public class Main {
    private static final Solution solution = new Solution();

    // formatter to print 2D array in the console, use it when answer is a 2D array
    private static final Function<Object, String> array2d = obj -> {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0, n = Array.getLength(obj); i < n; i++) {
            builder.append(Array.get(obj, i)).append(", ");
        }
        return builder.delete(builder.length() - 2, builder.length()).append("]").toString();
    };


    // main function, here you can try solutions
    public static void main(String[] args) throws Exception {
        solveGetFinalState();
        solveFindScore();
    }

    static void solveGetFinalState() {
        int[] nums = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        printAns(solution.getFinalState(nums, k, multiplier));
    }

    static void solveFindScore() throws IOException {
        String input = Files.readString(Paths.get("inputs/find_score_input.txt"));
        int[] nums = Arrays.stream(input.substring(1, input.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
        printAns(solution.findScore(nums));
    }

    /**
     * Prints the given answer in the console.
     * @param ans answer to be printed
     */
    static void printAns(Object ans) {
        printAns(ans, Object::toString);
    }

    /**
     * Prints the given answer in the console.
     * @param ans answer to be printed
     * @param formatter formatted to format how the answer to be printed
     */
    static void printAns(Object ans, Function<Object, String> formatter) {
        if (ans.getClass().isArray()) {
            printArray(ans, formatter);
        }
        else {
            System.out.println("Ans: " + formatter.apply(ans));
        }
    }

    // same as the `printAns` but works for array, don't have to call it directly
    private static void printArray(Object ans, Function<Object, String> formatter) {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0, n = Array.getLength(ans); i < n; i++) {
            builder.append(formatter.apply(Array.get(ans, i))).append(", ");
        }
        System.out.println("Ans: " + builder.delete(builder.length() - 2, builder.length()).append("]"));
    }
}

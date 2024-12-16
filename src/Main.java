import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    private static final Solution solution = new Solution();
    private static final Function<Object, String> array2d = obj -> {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0, n = Array.getLength(obj); i < n; i++) {
            builder.append(Array.get(obj, i)).append(", ");
        }
        return builder.delete(builder.length() - 2, builder.length()).append("]").toString();
    };

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

    static void printAns(Object ans) {
        printAns(ans, Object::toString);
    }

    static void printAns(Object ans, Function<Object, String> formatter) {
        if (ans.getClass().isArray()) {
            printArray(ans, formatter);
        }
        else {
            System.out.println("Ans: " + formatter.apply(ans));
        }
    }

    static void printArray(Object ans, Function<Object, String> formatter) {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0, n = Array.getLength(ans); i < n; i++) {
            builder.append(formatter.apply(Array.get(ans, i))).append(", ");
        }
        System.out.println("Ans: " + builder.delete(builder.length() - 2, builder.length()).append("]"));
    }
}

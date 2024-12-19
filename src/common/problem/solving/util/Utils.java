package common.problem.solving.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;

/**
 * The class {@code Utils} provides some static utility methods for reading input from a file
 * and printing output to the console.
 *
 * @author Karthikeyan T
 */
public class Utils {

    private Utils() {
        throw new UnsupportedOperationException("Utils class should not be initialized");
    }

    // formatter to print 2D array in the console, use it when answer is a 2D array
    public static final Function<Object, String> ARRAY_2D = obj -> {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0, n = Array.getLength(obj); i < n; i++) {
            builder.append(Array.get(obj, i)).append(", ");
        }
        return builder.delete(builder.length() - 2, builder.length()).append("]").toString();
    };

    /**
     * Reads the given file and returns an array of strings.
     * @param filename filename of the file
     * @return returns an array of strings
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static String[] readArray(String filename) throws IOException {
        return readArray(filename, ",", false);
    }

    /**
     * Reads the given file and returns an array of strings.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @return returns an array of strings
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static String[] readArray(String filename, String delimiter) throws IOException {
        return readArray(filename, delimiter, false);
    }

    /**
     * Reads the given file and returns an array of strings.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @param hasSurroundedBrackets {@code true} to remove surrounded brackets if any
     * @return returns an array of strings
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static String[] readArray(String filename, String delimiter, boolean hasSurroundedBrackets) throws IOException {
        if (filename == null || delimiter == null || filename.isEmpty()) {
            throw new IllegalArgumentException("arguments can't be null or empty");
        }
        String input = Files.readString(Paths.get(filename)).trim();
        input = hasSurroundedBrackets ? input.substring(1, input.length() - 1) : input;
        return input.split(delimiter);
    }

    /**
     * Reads the given file and returns an array of integers.
     * @param filename filename of the file
     * @return returns an array of integers
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static int[] readIntArray(String filename) throws IOException {
        return readIntArray(filename, ",", false);
    }

    /**
     * Reads the given file and returns an array of integers.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @return returns an array of integers
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static int[] readIntArray(String filename, String delimiter) throws IOException {
        return readIntArray(filename, delimiter, false);
    }

    /**
     * Reads the given file and returns an array of integers.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @param hasSurroundedBrackets {@code true} to remove surrounded brackets if any
     * @return returns an array of integers
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static int[] readIntArray(String filename, String delimiter, boolean hasSurroundedBrackets) throws IOException {
        return Arrays.stream(readArray(filename, delimiter, hasSurroundedBrackets)).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * Reads the given file and returns an array of longs.
     * @param filename filename of the file
     * @return returns an array of longs
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static long[] readLongArray(String filename) throws IOException {
        return readLongArray(filename, ",", false);
    }

    /**
     * Reads the given file and returns an array of longs.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @return returns an array of longs
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static long[] readLongArray(String filename, String delimiter) throws IOException {
        return readLongArray(filename, delimiter, false);
    }

    /**
     * Reads the given file and returns an array of longs.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @param hasSurroundedBrackets {@code true} to remove surrounded brackets if any
     * @return returns an array of longs
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static long[] readLongArray(String filename, String delimiter, boolean hasSurroundedBrackets) throws IOException {
        return Arrays.stream(readArray(filename, delimiter, hasSurroundedBrackets)).mapToLong(Long::parseLong).toArray();
    }

    /**
     * Reads the given file and returns an array of longs.
     * @param filename filename of the file
     * @return returns an array of longs
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static boolean[] readBooleanArray(String filename) throws IOException {
        return readBooleanArray(filename, ",", false);
    }

    /**
     * Reads the given file and returns an array of longs.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @return returns an array of longs
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static boolean[] readBooleanArray(String filename, String delimiter) throws IOException {
        return readBooleanArray(filename, delimiter, false);
    }

    /**
     * Reads the given file and returns an array of booleans.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @param hasSurroundedBrackets {@code true} to remove surrounded brackets if any
     * @return returns an array of booleans
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static boolean[] readBooleanArray(String filename, String delimiter, boolean hasSurroundedBrackets) throws IOException {
        String[] inputs = readArray(filename, delimiter, hasSurroundedBrackets);
        boolean[] result = new boolean[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            result[i] = Boolean.parseBoolean(inputs[i]);
        }
        return result;
    }

    /**
     * Reads the given file and returns an array of doubles.
     * @param filename filename of the file
     * @return returns an array of doubles
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static double[] readDoubleArray(String filename) throws IOException {
        return readDoubleArray(filename, ",", false);
    }

    /**
     * Reads the given file and returns an array of doubles.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @return returns an array of doubles
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static double[] readDoubleArray(String filename, String delimiter) throws IOException {
        return readDoubleArray(filename, delimiter, false);
    }

    /**
     * Reads the given file and returns an array of doubles.
     * @param filename filename of the file
     * @param delimiter delimiter to split the file content
     * @param hasSurroundedBrackets {@code true} to remove surrounded brackets if any
     * @return returns an array of doubles
     * @throws IOException throws IOException if any exceptions occurred in file reading
     */
    public static double[] readDoubleArray(String filename, String delimiter, boolean hasSurroundedBrackets) throws IOException {
        return Arrays.stream(readArray(filename, delimiter, hasSurroundedBrackets)).mapToDouble(Double::parseDouble).toArray();
    }

    /**
     * Prints the given answer in the console.
     * @param ans answer to be printed
     */
    public static void printAns(Object ans) {
        printAns(ans, Object::toString);
    }

    /**
     * Prints the given answer in the console.
     * @param ans       answer to be printed
     * @param formatter formatter to format how the answer to be printed
     */
    public static void printAns(Object ans, Function<Object, String> formatter) {
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

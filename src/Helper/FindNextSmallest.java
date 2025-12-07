package Helper;

import java.util.Arrays;
import java.util.Stack;

/**
 * GFG - https://www.geeksforgeeks.org/problems/help-classmates--141631/1
 * Each student helps only the next student that meet criteria
 * Criteria: student should help out a classmate who scored less marks than him
 */

public class FindNextSmallest {
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {3, 8, 5, 2, 25};
        int[] res = helpClassmate(arr, N); // => {2, 5, 2, -1, -1}
        System.out.println(Arrays.toString(res));
    }

    public static int[] helpClassmate(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // if the elements/marks in stack are greater, student can't help
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return res;
    }
}

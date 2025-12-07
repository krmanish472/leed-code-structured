package Stack;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int largestRectangle = maximalRectangle(matrix);
        System.out.println(largestRectangle);
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        // stores each row in int form - with each value sum of prev row el
        int[] height = new int[matrix[0].length];
        int laegest = 0;

        for (char[] chars : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                int val = chars[i] - '0';
                if (val == 0) {
                    height[i] = 0;
                } else {
                    height[i] += val; // or just 1
                }
            }

            int maxArea = largestRectangleArea(height);
            if (maxArea > laegest) {
                laegest = maxArea;
            }
        }
        return laegest;
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= heights.length; i++) {
            int element = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= element) {
                int height = heights[stack.pop()];
                // note: stack.peek() is prevHeight index
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }

            stack.push(i);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}

package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println(maxArea);
    }

    /**
     * add first el in stack and continue for next smaller element
     * pop out large element, calculate area, push el
     * find next smaller, keep adding and searching
     * [2, 1]   [5, 6, 2]
     */

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

package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        // Output: [1,1,4,2,1,1,0,0]
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> idxStack = new Stack<>();

        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!idxStack.isEmpty() &&
                    temperatures[i] >= temperatures[idxStack.peek()]) {
                idxStack.pop();
            }

            if (!idxStack.isEmpty()) {
                result[i] = idxStack.peek() - i;
            }

            idxStack.push(i);
        }

        return result;
    }

    public int[] dailyTemperatures_alt(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIdx = stack.pop();
                answer[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }

        return answer;
    }
}

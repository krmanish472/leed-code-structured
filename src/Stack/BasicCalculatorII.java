package Stack;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = "2+3*4-8/2+2"; // ans => 2+12-4+2 => 12
        int ans = calculate(s);
        System.out.println(ans);
    }

    public static int calculate(String s) {
        char operator = '+';
        int currentNumber = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar) - '0';
            }

            if (i == s.length() - 1 || currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                if (operator == '+') {
                    stack.push(currentNumber);
                } else if (operator == '-') {
                    stack.push(-currentNumber);
                } else if (operator == '*') {
                    // Pop the last number and multiply with current number
                    stack.push(stack.pop() * currentNumber);
                } else {
                    // Pop the last number and divide by current number
                    stack.push(stack.pop() / currentNumber);
                }

                operator = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

}

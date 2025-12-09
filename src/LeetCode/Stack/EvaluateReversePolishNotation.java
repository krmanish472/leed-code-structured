package LeetCode.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();

                int result = applyOperator(token, a, b);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(String operator, int a, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid Operator");
        };
    }
}

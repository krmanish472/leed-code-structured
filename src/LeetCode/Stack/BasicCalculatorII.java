package LeetCode.Stack;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = "2+3*4-8/2+2"; // ans => 2+12-4+2 => 12
        int ans = calculate(s);
        System.out.println(ans);
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        char operator = '+';
        int num = 0;


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch) - '0';
            }
            if (i == s.length() - 1 || isOperator(ch)) {
                switch (operator) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                operator = ch;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

}

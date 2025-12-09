package LeetCode.Stack;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int res = calculate(s);
        System.out.println(res);
    }

    public static int calculate(String s) {
        int sign = 1;
        int ans = 0;
        int num;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num = num * sign;
                ans += num;
                sign = 1;
            } else {
                switch (s.charAt(i)) {
                    case '+' -> sign = 1;
                    case '-' -> sign = -1;
                    case '(' -> {
                        stack.push(ans);
                        stack.push(sign);
                        ans = 0;
                        sign = 1;
                    }
                    case ')' -> {
                        int prevSign = stack.pop();
                        int prevAns = stack.pop();
                        ans = prevSign * ans;
                        ans = prevAns + ans;
                    }
                }
            }
        }

        return ans;
    }
}

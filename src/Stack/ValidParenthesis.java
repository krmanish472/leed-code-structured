package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(){()[]{}}";
        boolean is = isValid(s);
        System.out.println(is);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // add open brackets to stack
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            // check for closing brackets
            else if (stack.isEmpty()) {
                return false;
            } else {
                if ((c == ')' && stack.peek() == '(')
                        || (c == '}' && stack.peek() == '{')
                        || (c == ']' && stack.peek() == '['))
                    stack.pop();
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

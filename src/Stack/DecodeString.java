package Stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        decodeString(s); //accaccacc

    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }

            // number should be pushed if it appears before[. e.g. 3[
            if (c == '[') {
                numStack.push(k);
                k = 0; // reset k to 0
                stringStack.push(String.valueOf(c));
                continue;
            }
            // push characters in stack
            if (c != ']') {
                stringStack.push(String.valueOf(c));
                continue;
            }
            // when "]" is found, need to get all characters before "["
            StringBuilder sb = new StringBuilder();
            while (!stringStack.peek().equals("[")) {
                sb.insert(0, stringStack.pop()); // add characters before existing character
            }

            // remove "["
            stringStack.pop();

            // Build intermediate string - repeat the string till count
            int repeatCount = numStack.pop();
            StringBuilder intermediateString = new StringBuilder();
            while (repeatCount != 0) {
                intermediateString.append(sb);
                repeatCount--;
            }
            stringStack.push(intermediateString.toString()); // add intermediate string back to the stack
        }

        // final string - get all intermediate strings from stack
        StringBuilder result = new StringBuilder();
        while (!stringStack.empty()) {
            result.insert(0, stringStack.pop());
        }
        return result.toString();
    }
}

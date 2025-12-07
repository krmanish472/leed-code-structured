package Stack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] operations = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int res = calPoints(operations);
        System.out.println(res);
    }

    public static int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "C" -> st.pop();
                case "D" -> st.push(st.peek() * 2);
                case "+" -> {
                    int a = st.pop();
                    int b = st.peek();

                    st.push(a);
                    st.push(a + b);
                }
                default -> st.push(Integer.parseInt(operation));
            }
        }

        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
}

package LeetCode.Stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/home//user/./Documents/../Pictures";
        String path2 = "/../";
        String res = simplifyPath(path);
        System.out.println(res);
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String str : path.split("/")) {
            // skip '.' as it's not necessary
            if (str.isEmpty() || str.equals(".")) {
                continue;
            } // if '..' is found, no need of prev str, so remove it
            if (str.equals("..")) {
                if (!stack.isEmpty()) { // required as we n=might get "/../"
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}


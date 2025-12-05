package Stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
//        String path = "/home/user/./Documents/../Pictures";
        String path = "/../";
        String res = simplifyPath(path);
        System.out.println(res);
    }

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String str : arr) {
            // skip '.' as it's not necessary
            if (str.isEmpty() || str.equals(".")) {
                continue;
            } // if '..' is found, no need of prev str, so remove it
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
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

    public static String simplifyPath_alt(String path) {
        Stack<String> stack = new Stack<>();
        int n = path.length();

        int i = 0;
        while (i < n) {
            while (i < n && path.charAt(i) == '/') {
                i++;
            }
            if (i >= n) {
                break;
            }

            int j = i;
            while (i < n && path.charAt(i) != '/') {
                i++;
            }
            String str = path.substring(j, i); // home

            if (str.equals(".") || str.isEmpty()) {
                continue;
            }
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
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


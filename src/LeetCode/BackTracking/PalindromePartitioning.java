package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
* Given a string s, partition s such that every substring of the partition is a palindrome.
* Return all possible palindrome partitioning of s.
* Example 1:
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
* */

public class PalindromePartitioning {
    public static void main(String[] args) {
        String input = "aab";
        List<List<String>> res = partition(input);
        System.out.println(res);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    public static void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(result, current, s, end + 1);
                current.removeLast();
            }
        }
    }


    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

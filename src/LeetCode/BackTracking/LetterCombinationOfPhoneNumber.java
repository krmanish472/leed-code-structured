package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    private static String[] digitToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "23";
        // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        var res = letterCombinations(digits);
        System.out.println(res);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(digits, result, new StringBuilder(), 0);
        return result;
    }

    private static void backtrack(String digits, List<String> result, StringBuilder curr, int index) {
        if (index == digits.length()) {
            result.add(curr.toString());
            return;
        }

        String letters = digitToLetters[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            curr.append(letter);
            backtrack(digits, result, curr, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}

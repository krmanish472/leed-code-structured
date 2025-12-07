package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] pCharCount = new int[26];
        int[] sCharCount = new int[26];

        List<Integer> res = new ArrayList<>();

        for (char c : p.toCharArray()) {
            pCharCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCharCount[s.charAt(i) - 'a']++;

            // sliding window of 3 is required, if more than 3, remove first element
            // because index based, i >=3
            if (i >= p.length()) {
                sCharCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(pCharCount, sCharCount)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

}

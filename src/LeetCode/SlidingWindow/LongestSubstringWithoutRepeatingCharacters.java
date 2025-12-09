package LeetCode.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int maxLength = lengthOfLongestSubstring(s);
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int startPtr = 0;
        int maxLength = 0;

        // keep moving right pointer till we get unique
        for (int endPtr = 0; endPtr < s.length(); endPtr++) {
            // check for duplicate - until the char set contains the current char
            while (set.contains(s.charAt(endPtr))) {
                set.remove(s.charAt(startPtr));
                startPtr++;
            }
            set.add(s.charAt(endPtr));

            maxLength = Math.max(maxLength, endPtr - startPtr + 1);
        }

        return maxLength;
    }
}

package HashMap;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcaabcbb";
        int maxLength = lengthOfLongestSubstring(s);
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int leftPtr = 0;
        int maxLength = 0;

        // keep moving right pointer till we get unique
        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            // check for duplicate - until the char set contains the current char
            while (set.contains(s.charAt(rightPtr))) {
                set.remove(s.charAt(leftPtr));
                leftPtr++;
            }
            set.add(s.charAt(rightPtr));

            maxLength = Math.max(maxLength, rightPtr - leftPtr + 1); // +1 for 0 based index
        }

        return maxLength;
    }
}

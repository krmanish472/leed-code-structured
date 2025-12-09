package LeetCode.SlidingWindow;

import java.util.Arrays;

class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";

        if (checkInclusion(s1, s2)) {
            System.out.println("Permutation present");
        } else {
            System.out.println("Permutation not present");
        }
    }


    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int leftPtr = 0;
        for (int rightPtr = 0; rightPtr < s2.length(); rightPtr++) {
            s2Count[s2.charAt(rightPtr) - 'a']++;

            int k = s1.length();
            while (rightPtr - leftPtr + 1 > k) {
                s2Count[s2.charAt(leftPtr) - 'a']--;
                leftPtr++;
            }

            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        return false;
    }
}

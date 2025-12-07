package SlidingWindow;

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
        int[] counterA = new int[26];
        int[] counterB = new int[26];

        for (char c : s1.toCharArray()) {
            counterA[c - 'a']++;
        }

        int leftPtr = 0;
        for (int rightPtr = 0; rightPtr < s2.length(); rightPtr++) {
            char c = s2.charAt(rightPtr);
            counterB[c - 'a']++;

            while (rightPtr - leftPtr > s1.length() - 1) {
                char prev = s2.charAt(leftPtr);
                counterB[prev - 'a']--;
                leftPtr++;
            }
            if (Arrays.equals(counterA, counterB)) {
                return true;
            }
        }
        return false;
    }
}

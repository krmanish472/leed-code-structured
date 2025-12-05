package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        String str = minWindow(s, t);
        System.out.println(str);
    }

    public static String minWindow(String s, String t) {
        // count characters in s
        int[] arrS = new int[256];

        // count characters in t
        int[] arrT = new int[256];

        for (char ch : t.toCharArray()) {
            arrT[ch]++;
        }

        String result = "";
        int min = Integer.MAX_VALUE;

        int right = 0;
        for (int leftPtr = 0; leftPtr < s.length(); leftPtr++) {
            // right will travel all the way, once all elements of t are covered in s, loop breaks
            while (right < s.length() && !isDesirable(arrS, arrT)) {
                arrS[s.charAt(right)]++;
                right++;
            }

            if (isDesirable(arrS, arrT) && min > right - leftPtr + 1) {
                result = s.substring(leftPtr, right);
                min = right - leftPtr + 1;
            }

            // shrink left pointer - remove elements and try for next window
            arrS[s.charAt(leftPtr)]--;
        }

        return result;
    }

    private static boolean isDesirable(int[] mapS, int[] mapT) {
        // s should have all characters in t
        for (int i = 0; i < mapT.length; i++) {
            if (mapT[i] > mapS[i]) {
                return false;
            }
        }

        return true;
    }


    public String minWindow_alt(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int targetCharsRemaining = t.length();
        int[] minWindow = {0, Integer.MAX_VALUE};

        int startIndex = 0;

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                targetCharsRemaining--;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            if (targetCharsRemaining == 0) {
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                targetCharsRemaining++;
                startIndex++;
            }
        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }


}

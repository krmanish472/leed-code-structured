package LeetCode.SlidingWindow;


public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        String str = minWindow(s, t);
        System.out.println(str); // => BANC
    }

    public static String minWindow(String s, String t) {
        int[] sCount = new int[256];
        int[] tCount = new int[256];

        for (char ch : t.toCharArray()) {
            tCount[ch]++;
        }

        String result = "";
        int min = Integer.MAX_VALUE;

        int leftPtr = 0;
        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            // leftPtr will travel all the way, once all elements of t are covered in s, loop breaks
            while (leftPtr < s.length() && !isDesirable(sCount, tCount)) {
                sCount[s.charAt(leftPtr)]++;
                leftPtr++;
            }

            if (isDesirable(sCount, tCount) && min > leftPtr - rightPtr + 1) {
                result = s.substring(rightPtr, leftPtr);
                min = leftPtr - rightPtr + 1;
            }

            // shrink leftPtr pointer - remove elements and try for next window
            sCount[s.charAt(rightPtr)]--;
        }

        return result;
    }

    private static boolean isDesirable(int[] sCount, int[] tCount) {
        // s should have all characters in t
        for (int i = 0; i < tCount.length; i++) {
            if (tCount[i] > sCount[i]) {
                return false;
            }
        }

        return true;
    }
}
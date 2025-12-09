package LeetCode.SlidingWindow;

public class MaximumNumberOfVowels {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int maxValue = maxVowels(s, k);
        System.out.println(maxValue);
    }

    public static int maxVowels(String s, int k) {
        int currCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currCount++;
            }
        }

        int maxCount = currCount;
        int startPtr = 0;
        int endPtr = k;

        while (endPtr < s.length()) {
            if (isVowel(s.charAt(endPtr))) {
                currCount++;
            }
            if (isVowel(s.charAt(startPtr))) {
                currCount--;
            }

            maxCount = Math.max(currCount, maxCount);

            startPtr++;
            endPtr++;
        }

        return maxCount;
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'a' ||
                c == 'E' || c == 'e' ||
                c == 'I' || c == 'i' ||
                c == 'O' || c == 'o' ||
                c == 'U' || c == 'u';
    }
}

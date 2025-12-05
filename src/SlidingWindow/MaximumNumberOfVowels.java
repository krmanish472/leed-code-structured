package SlidingWindow;

public class MaximumNumberOfVowels {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        maxVowels(s, k);
    }

    public static int maxVowels(String s, int k) {
        int currCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currCount++;
            }
        }

        int maxCount = currCount;
        int startIdx = 0;
        int endIdx = k;

        while (endIdx < s.length()) {
            if (isVowel(s.charAt(startIdx))) {
                currCount--;
            }
            if (isVowel(s.charAt(endIdx))) {
                currCount++;
            }

            startIdx++;
            endIdx++;

            maxCount = Math.max(currCount, maxCount);

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

    public static int maxVowels_forLoopVersion(String s, int k) {
        int currCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currCount++;
            }
        }

        int maxCount = currCount;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) { // i-k gives the prev element
                currCount--;
            }
            if (isVowel(s.charAt(i))) {
                currCount++;
            }

            maxCount = Math.max(currCount, maxCount);

        }

        return maxCount;
    }

}

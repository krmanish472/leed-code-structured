package LeetCode.DynamicProgramming;

public class DecodeWays {
    public static void main(String[] args) {
        /**
         * Input: s = "123"
         * Output: 3
         * Explanation:
         * "123" could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW(1 23)".
         */

        String s = "123";
        int res = numDecodings(s);
        System.out.println(res);
    }

    public static int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (1 <= oneDigit && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}

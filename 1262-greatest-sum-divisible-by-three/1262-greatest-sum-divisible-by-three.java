class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] next = dp.clone();

            for (int r = 0; r < 3; r++) {
                if (dp[r] == Integer.MIN_VALUE) {
                    continue;
                }

                int newSum = dp[r] + num;
                int newRemainder = newSum % 3;

                next[newRemainder] =
                    Math.max(next[newRemainder], newSum);
            }

            dp = next;
        }

        return dp[0];
    }
}
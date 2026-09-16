class Solution {
    int[][] dp;
    final int M = 1000000007;

    public int numberOfSets(int n, int K) {
        dp = new int[n + 1][K + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int k = 1; k <= K; k++) {

            int sum = 0;

            for (int i = n - 1; i >= 0; i--) {

                int skip = dp[i + 1][k];

                if (i + 1 < n) {
                    sum = (sum + dp[i + 1][k - 1]) % M;
                }

                dp[i][k] = (skip + sum) % M;
            }
        }

        return dp[0][K];
    }
}
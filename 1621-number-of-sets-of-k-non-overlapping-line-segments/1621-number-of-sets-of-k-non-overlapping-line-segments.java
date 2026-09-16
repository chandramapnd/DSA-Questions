class Solution {
    static final int MOD = 1000000007;

    public int numberOfSets(int n, int K) {
        long[][] dp = new long[n][K + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int k = 1; k <= K; k++) {
            long sum = 0;

            for (int i = 1; i < n; i++) {

                sum = (sum + dp[i - 1][k - 1]) % MOD;

                dp[i][k] = (dp[i - 1][k] + sum) % MOD;
            }
        }

        return (int) dp[n - 1][K];
    }
}
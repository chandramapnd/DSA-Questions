class Solution {

    long MOD = 1000000007;
    Long[] dp;

    public int numDecodings(String s) {
        dp = new Long[s.length()];
        return (int) solve(s, 0);
    }

    private long solve(String s, int i) {
        if (i == s.length())
            return 1;

        if (dp[i] != null)
            return dp[i];

        long ans = 0;
        char c = s.charAt(i);

        // One-character decoding
        if (c == '*') {
            ans = (ans + 9 * solve(s, i + 1)) % MOD;
        } else if (c != '0') {
            ans = (ans + solve(s, i + 1)) % MOD;
        }

        // Two-character decoding
        if (i + 1 < s.length()) {
            char d = s.charAt(i + 1);

            if (c == '*' && d == '*') {
                // 11-19 and 21-26
                ans = (ans + 15 * solve(s, i + 2)) % MOD;
            } 
            else if (c == '*') {
                if (d >= '0' && d <= '6') {
                    // 1d or 2d
                    ans = (ans + 2 * solve(s, i + 2)) % MOD;
                } else {
                    // only 1d
                    ans = (ans + solve(s, i + 2)) % MOD;
                }
            } 
            else if (d == '*') {
                if (c == '1') {
                    // 11-19
                    ans = (ans + 9 * solve(s, i + 2)) % MOD;
                } else if (c == '2') {
                    // 21-26
                    ans = (ans + 6 * solve(s, i + 2)) % MOD;
                }
            } 
            else {
                int num = (c - '0') * 10 + (d - '0');
                if (num >= 10 && num <= 26) {
                    ans = (ans + solve(s, i + 2)) % MOD;
                }
            }
        }

        return dp[i] = ans;
    }
}
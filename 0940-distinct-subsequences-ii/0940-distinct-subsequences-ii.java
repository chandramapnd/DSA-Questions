class Solution {
    public int distinctSubseqII(String s) {

        final int MOD = 1000000007;

        long[] end = new long[26];

        for (char ch : s.toCharArray()) {

            int c = ch - 'a';

            long total = 1;

            for (int i = 0; i < 26; i++) {
                total += end[i];
            }

            end[c] = total % MOD;
        }

        long ans = 0;

        for (long x : end) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}
class Solution {
    public int integerBreak(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
    public int solve(int n, int []dp){
        if(n == 1){
            return 1;
        }

        if(dp[n]!=-1) return dp[n];

        int res = 0;

        for(int i=1;i<n;i++){
            res = Math.max(res, i * Math.max(n - i, solve(n-i, dp)));
        }
        return dp[n] = res;
    }
}
class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer [][]dp = new Integer[s.length()][s.length()];
        return solve(s, 0, s.length()-1, dp);
    }
    public int solve(String s, int i, int j, Integer [][]dp){
        if(i>j) return 0;
        if(i==j) return 1;

        if(dp[i][j]!=null) return dp[i][j]; 

        int res = 0;

        if(s.charAt(i) == s.charAt(j)){
            res = 2 + solve(s, i+1, j-1, dp);
        }else{
            res = Math.max(solve(s, i+1, j, dp), solve(s, i, j-1, dp));
        }

        return dp[i][j] = res;
    }
}
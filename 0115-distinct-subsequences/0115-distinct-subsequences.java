class Solution {
    int [][]dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int []a:dp){
            Arrays.fill(a, -1);
        }
        return solve(s, t, 0, 0);
    }
    public int solve(String s, String t, int i, int j){
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int res = solve(s, t, i+1, j);
        if(s.charAt(i) == t.charAt(j)){
            res += solve(s, t, i+1, j+1);
        }
        return dp[i][j] = res;
    }
    
}
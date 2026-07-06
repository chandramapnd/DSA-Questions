class Solution {
    public int minimumDeletions(String s) {
        int [][]dp = new int[s.length()][2];
        for(int []a : dp){
            Arrays.fill(a, -1);
        }
        return solve(s, 0, 1, dp);
    }
    public int solve(String s, int i, int state, int [][]dp){
        if(i >= s.length()) return 0;

        char ch = s.charAt(i);

        if(dp[i][state]!=-1) return dp[i][state];

        if(state == 1){
            if(ch == 'a'){
                dp[i][state] = solve(s, i+1, 1, dp);
            }else{
                dp[i][state] = Math.min(1 + solve(s, i+1, 1, dp), solve(s, i+1, 0, dp));
            }
        }else{
            if(ch == 'a'){
                dp[i][state] = 1 + solve(s, i+1, 0, dp);
            }else{
                dp[i][state] = solve(s, i+1, 0, dp);
            }
        }
        return dp[i][state];
    }
}
class Solution {
    public int numDecodings(String s) {
        int [][]dp = new int[s.length()][27];
        for(int []a : dp){
            Arrays.fill(a, -1);
        }
        return solve(s, 0, 0, dp);
    }
    public int solve(String s, int i, int prev, int [][]dp){
        if(i==s.length()) 
            return 1;
        
        if(dp[i][prev]!=-1) return dp[i][prev];

        int d = s.charAt(i) - '0';
        int two = prev * 10 + d;
        int res = 0;
        if(two >= 10 && two <=26){
            res += solve(s, i+1, two, dp);
        }

        if(d != 0)
            res += solve(s, i+1, d, dp);

        return dp[i][prev] = res;
      
    }
}
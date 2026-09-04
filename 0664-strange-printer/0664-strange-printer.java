class Solution {
    int [][]dp;
    public int strangePrinter(String s) {
        dp = new int[s.length()][s.length()];
        for(int []a : dp){
            Arrays.fill(a, -1);
        }
        return solve(0, s.length()-1, s);
    }
    public int solve(int l, int r, String s){
        if(l == r) return 1;
        if(l > r) return 0;
        
        if(dp[l][r]!=-1) return dp[l][r];

        int i = l+1;
        while(i <= r && s.charAt(i) == s.charAt(l)){
            i++;
        }
        if(i == r+1) return 1;

        int basic = 1 + solve(i, r, s);

        int extra = Integer.MAX_VALUE;

        for(int j = i;j<=r;j++){
            if(s.charAt(j) == s.charAt(l)){
                int ans = solve(i, j-1, s) + solve(j, r, s);
                extra = Math.min(extra, ans);
            }
        }

        return dp[l][r] = Math.min(extra, basic);
    }
}
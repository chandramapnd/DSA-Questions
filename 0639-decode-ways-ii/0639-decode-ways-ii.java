class Solution {
    public int numDecodings(String s) {
        long [][]dp = new long[s.length()][27];
        for(long []a : dp){
            Arrays.fill(a, -1);
        }
        return (int)solve(s, 0, 0, dp);
    }
    public long solve(String s, int i, int prev, long [][]dp){
        if(i == s.length()){
            return 1;
        }

        if(dp[i][prev]!=-1) return dp[i][prev];

        long res = 0;
        char ch = s.charAt(i);
        if(ch == '*'){
            for(int j=1;j<=9;j++){
                int d = j;
                int two = prev * 10 + d;
                if(two >= 10 && two <= 26){
                    res += solve(s, i+1, two, dp)% 1000000007;
                }

                if(d !=0){
                    res += solve(s, i+1, d, dp)% 1000000007;
                }
            }
        }else{
            int d = ch - '0';
            int two = prev * 10 + d;
            if(two >= 10 && two <= 26){
                res += solve(s, i+1, two, dp)% 1000000007;
            }

            if(d !=0){
                res += solve(s, i+1, d, dp) % 1000000007 ;
            }
            
        }
        return dp[i][prev] = res % 1000000007;
    }
}
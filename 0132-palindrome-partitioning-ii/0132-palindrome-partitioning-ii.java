class Solution {
    public int minCut(String s) {
        int n = s.length();

        boolean[][] isPal = new boolean[n][n];

        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2){
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i+1][j-1];
                    }
                }
            }
        }

        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            if(isPal[0][i]){
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;

                for(int j = 0; j < i; j++){
                    if(isPal[j+1][i]){
                        dp[i] = Math.min(dp[i], 1 + dp[j]);
                    }
                }
            }
        }

        return dp[n-1];
    }
}
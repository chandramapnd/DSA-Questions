class Solution {
    public int maxPalindromes(String s, int k) {
        if(k == 1) return s.length();
        int [][]dp = new int[s.length()][s.length()];
        for(int []a : dp){
            Arrays.fill(a, -1);
        }
        return solve(s, k, 0, k-1, dp);
    }
    public int solve(String s, int k, int i, int j, int [][]dp){
        int n = s.length();
        if(i >= n || j >=n){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int res = 0;

        if(isPalindrome(s, i, j)){
            res = 1 + solve(s, k, j+1, j+k, dp); //take

            res = Math.max(res, solve(s, k, i, j+1, dp)); 

            res = Math.max(res, solve(s, k, i+1, j+1, dp));

            return dp[i][j] = res;
            
        }else{
            res = Math.max(res, solve(s, k, i, j+1, dp));

            res = Math.max(res, solve(s, k, i+1, j+1, dp));
            return dp[i][j] = res;
        }
        
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
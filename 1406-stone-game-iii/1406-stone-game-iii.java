class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        int res = solve(stoneValue, 0, n, dp);
        if(res > 0){
            return "Alice";
        }else if(res < 0){
            return "Bob";
        }else{
            return "Tie";
        }
    }
    public int solve(int []arr, int i, int n, int []dp){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for(int j=i;j<i+3 && j < n;j++){
            sum += arr[j];
            res = Math.max(res, sum - solve(arr, j+1, n, dp));
        }
        return dp[i] = res;
    }
}
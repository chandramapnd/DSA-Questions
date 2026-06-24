class Solution {
    final int M = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int [][]dp = new int[locations.length][fuel+1];
        for(int []a: dp){
            Arrays.fill(a, -1);
        }
        return solve(locations, start, finish, fuel, dp);
    }
    public int solve(int[] locations, int start, int finish, int fuel, int [][]dp){
        if(fuel<0) return 0;

        if(dp[start][fuel]!=-1) return dp[start][fuel];
        int res = 0;

        if(start == finish){
            res += 1;
        }
        
        for(int i=0;i<locations.length;i++){
            if(i!=start){
                res = (res + solve(locations, i, finish, fuel - Math.abs(locations[i] - locations[start]), dp) % M) % M;
            }
        }
        return dp[start][fuel] = res;
    }
}
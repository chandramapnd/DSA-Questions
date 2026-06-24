class Solution {
    public int maxValue(int[][] events, int k) {
        int [][]dp = new int[events.length][k+1];
        for(int []a : dp){
            Arrays.fill(a, -1);
        }
        Arrays.sort(events, (a, b)->a[0] - b[0]);

        return solve(events, k, 0, dp);
    }
    public int solve(int [][]events, int k, int i, int [][]dp){
        int n = events.length;
        if(k <= 0 || i >=n) return 0;

        if(dp[i][k] != -1) return dp[i][k];

        int notTake = solve(events, k, i+1, dp);
        int take = events[i][2];
        int idx = binarySearch(events, i+1, events[i][1]);
        if(idx != -1){
            take += solve(events, k-1, idx, dp);
        }
        return dp[i][k] = Math.max(take, notTake);
    }
    public int binarySearch(int [][]events, int l, int target){
        int idx = -1;
        int r = events.length-1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if(events[mid][0]>target){
                idx = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return idx;
    }
}
class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]dp = new int[m][n];
        for(int []a: dp){
            Arrays.fill(a, -1);
        }
        int res = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res = Math.max(res, solve(matrix, i, j, Long.MAX_VALUE, dp));
            }
        }
        return res;
    }
    public int solve(int [][]matrix, int i, int j, long cur, int [][]dp){
        int m = matrix.length;
        int n = matrix[0].length;

        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j]==-1 || matrix[i][j]>=cur) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

         long temp = matrix[i][j];
        // matrix[i][j] = -1;

        int left = solve(matrix, i, j-1, temp, dp);
        int right = solve(matrix, i, j+1, temp, dp);
        int up = solve(matrix, i-1, j, temp, dp);
        int down = solve(matrix, i+1, j, temp, dp);

        //matrix[i][j] = (int)temp;
        return dp[i][j] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;

    }
}
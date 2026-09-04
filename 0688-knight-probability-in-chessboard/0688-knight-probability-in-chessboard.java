class Solution {
    double [][][]dp;
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n+2][n+2][k+2];
        for(int i=0;i<n+2;i++){
            for(int j=0;j<n+2;j++){
                for(int p=0;p<k+2;p++){
                    dp[i][j][p] = -1;
                }
            }
        }
        return solve(n, k, row, column);
    }

    public double solve(int n, int k, int r, int c) {

        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }


        if(dp[r][c][k]!=-1) return dp[r][c][k];

        double res = 0;

        res += solve(n, k - 1, r - 2, c + 1);
        res += solve(n, k - 1, r - 1, c + 2);
        res += solve(n, k - 1, r + 1, c + 2);
        res += solve(n, k - 1, r + 2, c + 1);
        res += solve(n, k - 1, r + 2, c - 1);
        res += solve(n, k - 1, r + 1, c - 2);
        res += solve(n, k - 1, r - 1, c - 2);
        res += solve(n, k - 1, r - 2, c - 1);

        return dp[r][c][k] = res / 8.0;
    }
}
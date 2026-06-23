class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return solve(triangle, 0, 0, dp);
    }

    public int solve(List<List<Integer>> triangle, int i, int j, Integer[][] dp) {

        if (i == triangle.size()) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] =
                triangle.get(i).get(j) +
                Math.min(
                    solve(triangle, i + 1, j, dp),
                    solve(triangle, i + 1, j + 1, dp)
                );
    }
}
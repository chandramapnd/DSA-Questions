class Solution {

    double[][] memo;

    public double soupServings(int n) {

        if(n > 5000) return 1;
        memo = new double[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return solve(n, n);
    }

    public double solve(int a, int b) {

        // Base cases
        if (a <= 0 && b <= 0) {
            return 0.5;
        }

        if (a <= 0) {
            return 1.0;
        }

        if (b <= 0) {
            return 0.0;
        }

        // Already calculated
        if (memo[a][b] != -1) {
            return memo[a][b];
        }

        double p = 0;

        p += solve(a - 100, b);
        p += solve(a - 75, b - 25);
        p += solve(a - 50, b - 50);
        p += solve(a - 25, b - 75);

        return memo[a][b] = p * 0.25;
    }
}
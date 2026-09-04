class Solution {
    Map<String, Double> map = new HashMap<>();

    public double knightProbability(int n, int k, int row, int column) {
        return solve(n, k, row, column);
    }

    public double solve(int n, int k, int r, int c) {

        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        String key = k + " "+ r + " "+ c;

        if(map.containsKey(key)) return map.get(key);

        double res = 0;

        res += solve(n, k - 1, r - 2, c + 1);
        res += solve(n, k - 1, r - 1, c + 2);
        res += solve(n, k - 1, r + 1, c + 2);
        res += solve(n, k - 1, r + 2, c + 1);
        res += solve(n, k - 1, r + 2, c - 1);
        res += solve(n, k - 1, r + 1, c - 2);
        res += solve(n, k - 1, r - 1, c - 2);
        res += solve(n, k - 1, r - 2, c - 1);

        map.put(key, res / 8.0);
        return res / 8.0;
    }
}
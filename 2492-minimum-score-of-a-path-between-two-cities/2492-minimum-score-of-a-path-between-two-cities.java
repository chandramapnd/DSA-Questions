class Solution {

    int[] parent;

    public int minScore(int n, int[][] roads) {

        parent = new int[n + 1];

        // Initially every city is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Connect all cities
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            union(u, v);
        }

        int root = find(1);

        int min = Integer.MAX_VALUE;

        // Find minimum edge in city 1's component
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            if (find(u) == root && find(v) == root) {
                min = Math.min(min, cost);
            }
        }

        return min;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int u, int v) {

        int parentU = find(u);
        int parentV = find(v);

        if (parentU != parentV) {
            parent[parentV] = parentU;
        }
    }
}
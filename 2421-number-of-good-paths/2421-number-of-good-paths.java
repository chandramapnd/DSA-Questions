class Solution {

    int[] parent;
    int[] rank;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        int n = vals.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++)
            map.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);

        int ans = 0;

        for (int value : map.keySet()) {

            
            for (int node : map.get(value)) {

                for (int nei : graph[node]) {

                    if (vals[nei] <= value)
                        union(node, nei);
                }
            }

            
            HashMap<Integer, Integer> count = new HashMap<>();

            for (int node : map.get(value)) {

                int root = find(node);

                count.put(root, count.getOrDefault(root, 0) + 1);
            }

            for (int c : count.values()) {

                ans += c * (c + 1) / 2;
            }
        }

        return ans;
    }

    int find(int x) {

        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {

        int px = find(x);
        int py = find(y);

        if (px == py)
            return;

        if (rank[px] < rank[py]) {

            parent[px] = py;

        } else if (rank[px] > rank[py]) {

            parent[py] = px;

        } else {

            parent[py] = px;
            rank[px]++;
        }
    }
}
class Solution {

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        int[][] dp = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {

                queue.offer(i);

                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            processed++;

            for (int c = 0; c < 26; c++) {
                answer = Math.max(answer, dp[u][c]);
            }

            for (int v : adj.get(u)) {

                int vColor = colors.charAt(v) - 'a';

                for (int c = 0; c < 26; c++) {

                    dp[v][c] = Math.max(
                        dp[v][c],
                        dp[u][c] + (c == vColor ? 1 : 0)
                    );
                }

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (processed != n) {
            return -1;
        }

        return answer;
    }
}
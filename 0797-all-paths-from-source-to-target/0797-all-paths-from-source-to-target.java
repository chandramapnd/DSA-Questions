class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, graph.length-1, res, new ArrayList<>());

        return res;

    }
    public void dfs(int [][]graph, int src, int dest, List<List<Integer>> res, List<Integer> cur){
        cur.add(src);

        if (src == dest) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int v : graph[src]) {
                dfs(graph, v, dest, res, cur);
            }
        }

        cur.remove(cur.size() - 1);
    }
}
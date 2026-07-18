class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int []res = new int[n];
        int []count = new int[26];
        dfs(adj, 0, -1, res, count, labels);
        return res;
    }
    public void dfs(List<List<Integer>> adj, int cur, int parent, int []res, int []count, String labels){
        char ch = labels.charAt(cur);

        int before = count[ch - 'a'];

        count[ch - 'a'] += 1;
        for(int v : adj.get(cur)){
            if(v == parent){
                continue;
            }
            dfs(adj, v, cur, res, count, labels);
        }

        int after = count[ch - 'a'];
        res[cur] = after - before;
    }
}
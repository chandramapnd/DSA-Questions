class Solution {
    int res = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<int []>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge: connections){
            adj.get(edge[0]).add(new int[]{edge[1], 1});
            adj.get(edge[1]).add(new int[]{edge[0], 0});
        }
        boolean []visited = new boolean[n];
        dfs(adj, 0, visited);
        return res;
    }
    public void dfs(List<List<int []>> adj, int u, boolean []visited){
        visited[u] = true;
        for(int []edge : adj.get(u)){
            int v = edge[0];
            if(!visited[v]){
                if(edge[1] == 1){
                    res++;
                }
                dfs(adj, v, visited);
            }
        }
    }
}
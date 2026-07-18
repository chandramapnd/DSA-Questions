class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean []visited = new boolean[n];
        return dfs(adj, source, visited, destination);
    }
    public boolean dfs(List<List<Integer>> adj, int u, boolean []visited, int dest){
        if(u==dest) return true;
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                
                if(dfs(adj, v, visited, dest)){
                    return true;
                }
            }
        }
        return false;
    }
}
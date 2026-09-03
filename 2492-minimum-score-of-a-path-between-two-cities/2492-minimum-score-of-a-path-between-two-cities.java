class Solution {
    int min = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<int []>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []road : roads){
            int u = road[0] -1;
            int v = road[1] -1;
            int  cost = road[2];
            adj.get(u).add(new int[]{v, cost});
            adj.get(v).add(new int[]{u, cost});
        }

        boolean []visited = new boolean[n];
        dfs(0, adj, visited);
        return min;
    }
    public void dfs(int u, List<List<int []>> adj, boolean []visited){
        visited[u] = true;
        for(int [] edge : adj.get(u)){
            int v = edge[0];
            int cost = edge[1];
            min = Math.min(cost, min);
            if(!visited[v]){
                dfs(v, adj, visited);
            }
        }

    }
}
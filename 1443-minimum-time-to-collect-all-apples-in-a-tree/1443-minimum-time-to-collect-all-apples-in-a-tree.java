class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(adj, 0, -1, hasApple);
    }
    public int dfs(List<List<Integer>> adj, int cur, int parent, List<Boolean> hasApple){
        int time = 0;
        for(int child : adj.get(cur)){
            if(child==parent){
                continue;
            }

            int timeFromChild = dfs(adj, child, cur, hasApple);

            if(timeFromChild > 0 || hasApple.get(child)){
                time += timeFromChild + 2;
            }
        }

        return time;
    }
}
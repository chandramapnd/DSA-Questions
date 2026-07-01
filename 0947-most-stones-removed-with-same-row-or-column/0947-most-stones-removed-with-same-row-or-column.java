class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean visited[] = new boolean[n];

        int group = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(stones, i, visited);
                group++;
            }
        }
        return n - group;
    }
    public void dfs(int [][]stones, int u, boolean []visited){
        visited[u] = true;
        for(int v=0;v<stones.length;v++){

            int r = stones[u][0];
            int c = stones[u][1];
            if(!visited[v] && (stones[v][0] == r || stones[v][1] == c)){
                dfs(stones, v, visited);
            }
        }
    }
}
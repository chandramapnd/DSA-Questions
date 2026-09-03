class Solution {
    int max = -1;
    public int longestCycle(int[] edges) {
        int []visited = new int[edges.length];
        int []count = new int[edges.length];
        Arrays.fill(count, -1);
        for(int i=0;i<edges.length;i++){
            if(visited[i]==0){
                dfs(edges, i, visited, count);
            }
        }
        return max;
    }
    public void dfs(int []edges, int u, int []visited, int []count){
        if(u!=-1){
            visited[u] = 1;
            int v = edges[u];
            
            if(v != -1 && visited[v] == 0){
                count[v] = count[u] + 1;
                dfs(edges, v, visited, count);
            }else if(v != -1 && visited[v]==1){
                max = Math.max(max, count[u] - count[v] + 1);
            }

            visited[u] = 2;
        }
    }
    
}
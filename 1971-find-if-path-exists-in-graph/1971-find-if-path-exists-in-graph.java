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
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            int u = q.poll();
            if(u==destination) return true;
            for(int v : adj.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        return false;
    }
    
}
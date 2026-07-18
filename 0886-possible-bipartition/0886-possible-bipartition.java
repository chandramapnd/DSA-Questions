class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : dislikes){
            adj.get(edge[0]-1).add(edge[1]-1);
            adj.get(edge[1]-1).add(edge[0]-1);
        }
        int visited[] = new int[n];
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){

            if (visited[i] != -1)
                continue;

            q.offer(i);
            visited[i] = 1;
            while(!q.isEmpty()){
                int u = q.poll();
                int cur = visited[u];
                for(int v : adj.get(u)){
                    if(visited[v]==cur) return false;

                    if(visited[v] == -1){
                        visited[v] = 1 - cur;
                        q.offer(v);
                    }
                }
            }
        }
        return true;
    }
}
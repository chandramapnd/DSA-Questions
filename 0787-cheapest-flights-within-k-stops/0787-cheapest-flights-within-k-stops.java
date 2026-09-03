class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int []dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int steps = 0;
        while(!q.isEmpty() && steps <= k){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int u = q.peek()[0];
                int d = q.peek()[1];
                q.poll();

                for(int[] p : adj.get(u)){
                    int v = p[0];
                    int cost = p[1];

                    if(dist[v] > cost + d){
                        dist[v] = cost + d;
                        q.offer(new int[]{v, dist[v]});
                    }
                }
            }
            steps++;
        }
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
}
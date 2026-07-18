class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean []visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : rooms.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}
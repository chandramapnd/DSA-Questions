class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(List<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
            indegree[edge.get(1)]++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
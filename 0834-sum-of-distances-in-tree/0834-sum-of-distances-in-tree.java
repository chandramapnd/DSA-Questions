class Solution {
    int rootSum = 0;
    int count[];
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        count = new int[n];
        dfsBase(adj, 0, -1, 0);

        int []result = new int[n];
        result[0] = rootSum;

        DFS(adj, 0, -1, result);
        return result;

    }
    public void DFS(List<List<Integer>> adj, int parentNode, int prevNode, int []res){
        for(int v : adj.get(parentNode)){
            if(v == prevNode){
                continue;
            }
            res[v] = res[parentNode] - count[v] + (adj.size() - count[v]);
            DFS(adj, v, parentNode, res);
        }
    }
    public int dfsBase(List<List<Integer>> adj, int curNode, int prevNode, int curDepth){
        int total = 1;
        rootSum += curDepth;

        for(int v : adj.get(curNode)){
            if(v == prevNode){
                continue;
            }
            total += dfsBase(adj, v, curNode, curDepth + 1);
        }
        count[curNode] = total;

        return total;

        
    }
}
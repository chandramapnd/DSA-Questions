class Solution {
    int []parent;
    int []rank;
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        List<int []> query = new ArrayList<>();
        int c = 0;
        for(int []q : queries){
            query.add(new int[]{q[0], q[1], q[2], c++});
        }

        Collections.sort(query, (a, b)->a[2] - b[2]);
        Arrays.sort(edgeList, (a, b)->a[2] - b[2]);

        boolean []res = new boolean[query.size()];
        int j=0;

        for(int i=0;i<query.size();i++){
            int []a = query.get(i);
            while(j < edgeList.length && edgeList[j][2] < a[2]){
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }

            if(find(a[0]) == find(a[1])){
                res[a[3]] = true;
            }
        }
        return res;

    }
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(rank[px] < rank[py]){
            parent[px] = py;
        }else if(rank[px] > rank[py]){
            parent[py] = px;
        }else{
            parent[px] = py;
            rank[py]++;
        }
    }

}
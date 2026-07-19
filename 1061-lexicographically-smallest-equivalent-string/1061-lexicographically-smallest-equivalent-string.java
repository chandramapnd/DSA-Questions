class Solution {
    int parent[] = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i=0;i<26;i++){
            parent[i] = i;
        }

        for(int i=0;i<s1.length();i++){
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            union(u, v);
        }

        StringBuilder ans = new StringBuilder();
        for(char ch : baseStr.toCharArray()){
            ans.append((char)(find(ch - 'a') + 'a'));
        }

        return ans.toString();
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px < py){
            parent[py] = px;
        }else{
            parent[px] = py;
        }
    }
}
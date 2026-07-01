class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet();
        for(String str: bank){
            set.add(str);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        visited.add(startGene);
        int level = 0;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                String cur = q.poll();
                if(cur.equals(endGene)){
                    return level;
                }

                for(char ch:"ACGT".toCharArray()){
                    for(int j=0;j<cur.length(); j++){
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(j,ch);
                        String neighbour = sb.toString();
                        if(!visited.contains(neighbour) && set.contains(neighbour)){
                            visited.add(neighbour);
                            q.add(neighbour);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
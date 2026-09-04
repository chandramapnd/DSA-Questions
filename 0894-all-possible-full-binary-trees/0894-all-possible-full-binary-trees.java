
class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        
        return solve(n);
    }
    public List<TreeNode> solve(int n){
        if(n%2==0) return (new ArrayList<>());

        if(n == 1){ 
            List<TreeNode> res = new ArrayList<>(); 
            res.add(new TreeNode(0));
            return res;
        }

        if(map.containsKey(n)) return map.get(n);

        List<TreeNode> res = new ArrayList<>();

        for(int i=1;i<n;i+=2){
            List<TreeNode> lfbt = solve(i);
            List<TreeNode> rfbt = solve(n - i -1);

            for(TreeNode l : lfbt){
                for(TreeNode r : rfbt){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        map.put(n, res);
        return res;
    }
}
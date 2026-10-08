class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, target, 0, new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> cur : set){
            res.add(cur);
        }
        return res;
    }
    public void solve(int []nums, int target, int i, List<Integer> cur){
        if(i >= nums.length || target < 0){
            return;
        }
        if (target == 0) {
            set.add(new ArrayList<>(cur));
            return;
        }

        solve(nums, target, i+1, cur);

        cur.add(nums[i]);
        solve(nums, target - nums[i], i, cur);
        cur.remove(cur.size() - 1);

    }

}
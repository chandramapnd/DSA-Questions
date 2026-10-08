class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        solve(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void solve(int[] nums, int target, int start, List<Integer> cur, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            cur.add(nums[i]);

            solve(nums, target - nums[i], i + 1, cur, res);

            cur.remove(cur.size() - 1);
        }
    }
}
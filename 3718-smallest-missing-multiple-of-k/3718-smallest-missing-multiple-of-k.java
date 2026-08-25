class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums){
            set.add(a);
        }
        int n = k;
        for(int i=0;i<=nums.length;i++){
            if(!set.contains(n)){
                return n;
            }
            n += k;
        }
        return k;
    }
}
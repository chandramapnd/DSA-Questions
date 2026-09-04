class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int []minP = new int[nums.length];
        int min = Integer.MAX_VALUE;

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<min){
                min = nums[i];
            }
            minP[i] = min;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max = nums[i];
            }
            if(max - minP[i] <= k){
                return i;
            }
        }
        return -1;
    }
}
class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int zero = 0;
        int left = 0;
        for(int right = 0; right<nums.length;right++){
            if(nums[right] == 0){
                zero++;
            }
            while(zero > 1){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        if(max == nums.length){
            return max - 1;
        }else{
            return max;
        }
    }
}
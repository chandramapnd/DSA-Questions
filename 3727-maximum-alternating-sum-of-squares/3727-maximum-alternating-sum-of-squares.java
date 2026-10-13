class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        long res = 0;
        int l = 0, r = nums.length-1;
        while(l<=r){
            if(l==r){
                res += nums[l];
            }else{
                res = res + nums[r] - nums[l];
            }
            l++;
            r--;
        }
        return res;
    }
}
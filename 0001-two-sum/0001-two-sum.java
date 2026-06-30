class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int a=-1,b=-1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a = i;
                    b = j;
                }
            }
        }
        return new int[]{a,b};
    }
}
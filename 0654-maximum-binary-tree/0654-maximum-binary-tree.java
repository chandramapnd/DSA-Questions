/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
    public TreeNode solve(int []nums, int left, int right){
        if(left>right) return null;

        int max = nums[left];
        int ind = left;
        for(int i=left+1;i<=right;i++){
            if(max < nums[i]){
                max = nums[i];
                ind = i;
            }
        }

        TreeNode root = new TreeNode(nums[ind]);
        root.left = solve(nums, left, ind - 1);
        root.right = solve(nums, ind + 1, right);
        return root;
    }
}
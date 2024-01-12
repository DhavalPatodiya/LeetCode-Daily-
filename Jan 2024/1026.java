

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/?envType=daily-question&envId=2024-01-11
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
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int min, int max){
        if(root == null){
            return ;
        }

        ans = Math.max(ans, Math.abs(max - root.val));
        ans = Math.max(ans, Math.abs(min - root.val));
        

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}

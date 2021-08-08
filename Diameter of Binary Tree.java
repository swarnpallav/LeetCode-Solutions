// Problem link below
//https://leetcode.com/problems/diameter-of-binary-tree/

class Solution {
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return d;
    }
    int help(TreeNode root)
    {
        if(root == null) return 0;
        
        int left = help(root.left);
        int right = help(root.right);
        
        d = Math.max(d, left + right);
        
        return Math.max(left, right) + 1;
    }
}

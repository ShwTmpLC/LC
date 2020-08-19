class Solution {
 
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}

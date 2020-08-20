class Solution {
    private int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }
    
    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}

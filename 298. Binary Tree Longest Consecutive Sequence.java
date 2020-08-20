class Solution {
    private int gMaxLength = 1;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, null, 1);
        return gMaxLength;
    }
    
    private void dfs(TreeNode node, TreeNode prev, int curLength) {
        if (node == null) {
            return;
        }
        if (prev != null && node.val == prev.val + 1) {
            curLength++;
            gMaxLength = Math.max(curLength, gMaxLength);
        } else {
            curLength = 1;
        }
        
        dfs(node.left, node, curLength);
        dfs(node.right, node, curLength);
    }
}

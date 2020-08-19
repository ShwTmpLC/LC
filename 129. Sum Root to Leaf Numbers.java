class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int prevSum) {
        if (node.left == null && node.right == null) {
            return prevSum * 10 + node.val;
        }
        
        int backSum = 0;
        if (node.left != null) {backSum += dfs(node.left, prevSum * 10 + node.val);}
        if (node.right != null) {backSum += dfs(node.right, prevSum * 10 + node.val);}
        return backSum;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, 0, result);
        return result;
        
    }
    public void dfs(TreeNode node, int curLevel, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        if (curLevel == result.size()) {
            result.add(node.val);
        }
        
        dfs(node.right, curLevel + 1, result);
        dfs(node.left, curLevel + 1, result);
    }
}

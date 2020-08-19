class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curResult = new LinkedList<>();
        
        if (root == null) {
            return result;
        }
        
        dfsWithBacktrack(root, sum, curResult, result);
        return result;
    }
    
    
    void dfsWithBacktrack(TreeNode node, int sum, List<Integer> curResult, List<List<Integer>> result) {
        curResult.add(new Integer(node.val));
        
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new LinkedList(curResult));
            curResult.remove(curResult.size() - 1); 
            return;
        }
        
        if (node.left != null) {
            dfsWithBacktrack(node.left, sum - node.val, curResult, result);
        }
        if (node.right != null) {
            dfsWithBacktrack(node.right, sum - node.val, curResult, result);
        }
        curResult.remove(curResult.size() - 1); 
    }
}

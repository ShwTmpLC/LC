Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        dfs(node.left, result);
        dfs(node.right, result);
    }
}

Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        if (root == null) {
            return result;
        }
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            result.add(curNode.val);
            if (curNode.right != null) stack.push(curNode.right);
            if (curNode.left != null) stack.push(curNode.left);
        }
        return result;
    }
}

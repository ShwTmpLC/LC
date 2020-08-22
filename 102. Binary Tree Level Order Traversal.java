//BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int numNode = queue.size();
            List<Integer> curResult = new LinkedList<>();
            for (int i = 0; i < numNode; i++) {
                TreeNode node = queue.poll();
                curResult.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(curResult);
        }
        return result;
    }
}

//DFS with level
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        dfs(root, 0, result);
        return result;
        
    }
    
    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new LinkedList<>());
        }
        
        result.get(level).add(node.val);
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}

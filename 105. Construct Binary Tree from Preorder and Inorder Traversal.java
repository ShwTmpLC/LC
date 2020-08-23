class Solution {
    private Map<Integer, Integer> inMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
           inMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
            
        int rootVal = preorder[preStart];
        int rootInIndex = inMap.get(rootVal);
        
        TreeNode node = new TreeNode(rootVal);
        
        int relativeRootInIndex = rootInIndex - inStart;
        node.left = helper(preorder, preStart + 1, preStart + 1 + relativeRootInIndex - 1, inorder, inStart, rootInIndex - 1);
        node.right = helper(preorder, preStart + 1 + relativeRootInIndex, preEnd, inorder, rootInIndex + 1, inEnd);
        
        return node; 
    }
}

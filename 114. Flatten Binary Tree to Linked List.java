class Solution {
    public void flatten(TreeNode root) {
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.left != null) {
                TreeNode rightBottom = curNode.left;
                while (rightBottom.right != null) rightBottom = rightBottom.right;
                
                rightBottom.right = curNode.right;
                curNode.right = curNode.left;
                curNode.left = null;
            }
            curNode = curNode.right;
        }
    }
}

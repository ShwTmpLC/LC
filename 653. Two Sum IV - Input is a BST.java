
//  2sum on leftPath + rightPath with "two pointers" approach
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        
        Stack<TreeNode> leftStack = new Stack<>();
    	Stack<TreeNode> rightStack = new Stack<>();
        
        // put left node into leftStack, to start with nodes with smallest value
        TreeNode curNode = root;
        while (curNode != null){
    	    leftStack.push(curNode);
            curNode = curNode.left;
    	}
        
        // put right node into rightStack, to start with nodes with smallest value
        curNode = root;
        while (curNode != null){
    	    rightStack.push(curNode);
            curNode = curNode.right;
    	}
        
    	while (leftStack.peek() != rightStack.peek()) { // if end
            int sum = leftStack.peek().val + rightStack.peek().val;
            if (sum == k) {
                return true;
            }
            else if (sum > k) {
                // move pointer on the right path
                TreeNode node = rightStack.pop().left;
                while (node != null) {
                    rightStack.push(node);
                    node = node.right;
                }
            }
            else {
                // move pointer on the left path
                TreeNode node = leftStack.pop().right;
                while (node != null) {
                    leftStack.push(node);
                    node = node.left;
                }
            }
        }
        return false;
    }
}

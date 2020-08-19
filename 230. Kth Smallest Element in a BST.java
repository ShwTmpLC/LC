// 二分查找
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countSubTree(root.left);
        if (leftCount == k - 1) {
            return root.val;
        } else if (leftCount > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }
    
    private int countSubTree(TreeNode root) {
        if (root == null) return 0;
        return countSubTree(root.left) + countSubTree(root.right) + 1;
    }
}

// in order traverse

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (k == 0) return cur.val;
            
            cur = cur.right;
        }
        return -1;
    }
}

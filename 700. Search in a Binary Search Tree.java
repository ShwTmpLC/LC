(1)recursive

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        else if (val > root.val) {
            return searchBST(root.right, val);
        }
        else {
            return searchBST(root.left, val);
        }
    }
}

(2) iterative

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            else if (val > root.val) {
                root = root.right;
            } else if (val < root.val) {
                root = root.left;
            }
        }
        return null;
    }
}

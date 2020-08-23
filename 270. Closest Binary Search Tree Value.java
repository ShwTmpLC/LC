class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        
        int closest = root.val;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(cur.val - target) < Math.abs(closest - target)) closest = cur.val;
            cur = target < cur.val ? cur.left : cur.right;
        }
        return closest;
    }
}

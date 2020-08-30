/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        return buildBSTree(head, null);
    }
    
    private TreeNode buildBSTree(ListNode start, ListNode end){
        if(start == end) return null;
        
        // find mid, 
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode mid = slow;
        
        // recursively build
        TreeNode node = new TreeNode(mid.val);
        node.left = buildBSTree(start, mid);
        node.right = buildBSTree(mid.next, end);
        
        return node;
    }
}

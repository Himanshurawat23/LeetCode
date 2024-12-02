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
    public TreeNode call(ListNode head,ListNode tail){
        if(head==tail)return null;
        ListNode fast = head;
        ListNode slow=head;
        while(fast!=tail && fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode mid=new TreeNode(slow.val);
        mid.left=call(head,slow);
        mid.right=call(slow.next,tail);
        return mid;
        
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        return null;
        
        return call(head,null);
    }
}
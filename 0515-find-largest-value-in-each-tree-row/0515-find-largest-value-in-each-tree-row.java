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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> qu= new LinkedList<TreeNode>();
        List<Integer> ll = new LinkedList<Integer>();
        if(root==null)
        return ll;
        qu.offer(root);
         while(!qu.isEmpty()){
            int size=qu.size();
            int max=Integer.MIN_VALUE;
            for(int i=1;i<=size;i++){
                if(qu.peek().left!=null){
                    qu.offer(qu.peek().left);
                }
                if(qu.peek().right!=null){
                    qu.offer(qu.peek().right);
                }
                max=Math.max(max,qu.poll().val);
            }
            ll.add(max);
        }
        return ll;
    }
}
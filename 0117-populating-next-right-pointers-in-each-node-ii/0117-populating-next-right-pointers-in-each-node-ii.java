/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> qu = new LinkedList<>();
        if(root==null)return root;
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            Node prev=null;
            for(int i=1;i<=size;i++){
                Node h=qu.poll();
                if(prev!=null){
                    prev.next=h;
                }
                prev=h;
                if(h.left!=null){
                    qu.add(h.left);
                }
                if(h.right!=null){
                    qu.add(h.right);
                }
            }
        }
        return root;

    }
}
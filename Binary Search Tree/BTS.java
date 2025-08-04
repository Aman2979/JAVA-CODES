class Node{
    int val;
    Node left, right;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class applyBTS{
    public static Node function(Node root, int node){
        while (root != null && root.val != node){
            root = node < root.val ? root.left : root.right;
//            if (node < root.val){
//                root = root.left;
//            }else {
//                root = root.left;
//            }
        }
        return root;
    }
}
public class BTS {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(10);
        root.right.right = new Node(14);
        int node = 20;
        System.out.println(applyBTS.function(root,node));
    }
}

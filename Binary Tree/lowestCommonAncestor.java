class tree1{
    int data;
    tree1 left, right;
    tree1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class checkerAncestor{
    public static tree1 function(tree1 root, tree1 p, tree1 q){
        if (root == null || p == root || q == root){
            return root;
        }

        tree1 left = function(root.left, p, q);
        tree1 right = function(root.right, p, q);

        //My final Answer.
        if(left == null){
            return right;
        } else if (right == null) {
            return left;
        }else {
            return root;
        }
    }
}
public class lowestCommonAncestor {
    public static void main(String[] args) {
        //Given Nodes


        //main tree
        tree1 root = new tree1(1);
        root.left = new tree1(2);
        root.right = new tree1(3);
        root.right.left = new tree1(4);
        root.right.right = new tree1(5);

        // Use actual references from the tree
        tree1 p = root.right.left;  // Node with value 4
        tree1 q = root.right.right; // Node with value 5
        System.out.println(checkerAncestor.function(root, p, q));
    }
}

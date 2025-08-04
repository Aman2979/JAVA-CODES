class TreeNode1{
    int data;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class countNodeInTree{
    public static int inOrder(TreeNode1 root) {
        if (root == null) return 0; // Base case: if the node is null, return 0
        return 1 + inOrder(root.left) + inOrder(root.right); // Count current node + left subtree + right subtree
    }

    public static int countNodes(TreeNode1 root) {
        return inOrder(root); // Calls the inOrder traversal and returns total count
    }
}
public class countTheNumberOfNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(3);
        root.left = new TreeNode1(5);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(6);
        root.left.right = new TreeNode1(2);
        root.left.right.left = new TreeNode1(7);
        root.left.right.right = new TreeNode1(4);
        root.right.left = new TreeNode1(0);
        root.right.right = new TreeNode1(8);

        System.out.println(countNodeInTree.countNodes(root));
    }
}

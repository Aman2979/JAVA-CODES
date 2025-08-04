class TreeNode5{
    int val;
    TreeNode5 left, right;

    TreeNode5(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class solution{
    public static TreeNode5 inorderSuccessor(TreeNode5 root, TreeNode5 p){
        TreeNode5 Successor = null;
        while (root != null){
            if (p.val >= root.val){
                root = root.right;
            }else {
                Successor = root;
                root = root.left;
            }
        }
        return Successor;
    }
}
public class inorderSuccessorInBST {
    public static void main(String[] args) {
    }
}

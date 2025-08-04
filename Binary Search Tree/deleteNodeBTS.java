class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class helper{
    //main function...
    public static TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;
        if (root.val == key) return helper(root);

        TreeNode dummy = root;
        while (root != null){
            if (root.val > key){
                if (root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }else {
                    root = root.left;
                }
            }else {
                if (root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public static TreeNode helper(TreeNode root){
        if (root.left == null){
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    public static TreeNode findLastRight(TreeNode root){
        if (root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }
}
public class deleteNodeBTS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int key = 4;
    }
}

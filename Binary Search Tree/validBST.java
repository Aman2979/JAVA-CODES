class TreeNode2{
    int val;
    TreeNode2 left, right;

    TreeNode2(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class check{
    public static boolean isValidBST(TreeNode2 root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode2 root, long minVal, long maxVal){
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val)
                && isValidBST(root.right, root.val, maxVal);
    }
}
public class validBST {
    public static void main(String[] args) {

    }
}

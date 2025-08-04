class TreeNode4{
    int val;
    TreeNode4 left, right;

    TreeNode4(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class action{
    public static TreeNode4 bstFromPreorder(int []preorder, int bound,int [] i){
        if (i[0] == preorder.length || preorder[i[0]] > bound) return null;
        TreeNode4 root = new TreeNode4(preorder[i[0]++]);
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }
    public static TreeNode4 bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}
public class preOrderToBST {
    public static void main(String[] args) {

    }
}

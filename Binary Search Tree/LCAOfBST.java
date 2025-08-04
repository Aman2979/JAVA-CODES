class TreeNode3{
    int val;
    TreeNode3 left, right;

    TreeNode3(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class checker{
    public static TreeNode3 lowestCommonAncestor(TreeNode3 root, TreeNode3 p, TreeNode3 q){
        if (root == null) return null;
        int curr = root.val;
        if (curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
public class LCAOfBST {
    public static void main(String[] args) {

    }
}

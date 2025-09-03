import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }

    public static int width(TreeNode root){
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(6);
        System.out.println(width(root));
    }
}

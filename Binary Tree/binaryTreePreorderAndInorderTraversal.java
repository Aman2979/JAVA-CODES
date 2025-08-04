import java.util.*;

class TreeNode2{
    int data;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class constructBinary{
    public static TreeNode2 buildTree(int []preorder, int preStart, int preEnd,
                                   int []inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode2 root = new TreeNode2(preorder[preStart]);

        int inRoot = inMap.get(root.data);
        int numsLeft =  inRoot - inStart;

        root.left = buildTree(preorder, preStart+1, preStart+numsLeft,
                inorder, inStart, inRoot-1, inMap);

        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd,
                inorder, inRoot+1, inEnd, inMap);
        return root;
    }


    public static TreeNode2 buildTree(int[] preorder, int[] inorder){
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode2 root = buildTree(preorder, 0, preorder.length-1, inorder,
                          0, inorder.length-1, inMap);
        return root;
    }
}
public class binaryTreePreorderAndInorderTraversal {
    public static void main(String[] args) {
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        System.out.println(constructBinary.buildTree(preorder, inorder));
    }
}

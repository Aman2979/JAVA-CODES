import java.util.*;

class TreeNode3{
    int data;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class toFindUniqueBinaryTree{
    public static TreeNode3 buildPostOrderIn(int [] inorder, int inStart, int inEnd,
                                             int [] postorder, int postStart, int postEnd,
                                             Map<Integer, Integer> map){
        if (postStart > postEnd || inStart > inEnd){
            return null;
        }
        TreeNode3 root = new TreeNode3(postorder[postEnd]);
        int inRoot = map.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;
        root.left = buildPostOrderIn(inorder, inStart, inRoot-1, postorder,
                postStart, postStart+numsLeft-1, map);

        root.right = buildPostOrderIn(inorder, inRoot+1, inEnd, postorder,
                postStart+numsLeft, postEnd-1, map);
        return root;
    }


    public static TreeNode3 buildTree(int[] inorder, int[] postorder) {
        if (inorder ==  null || postorder == null || inorder.length != postorder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildPostOrderIn(inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1, map);
    }
}
public class constructBinaryTreePostorderAndInorderTraversal {
    public static void main(String[] args) {
        int [] postorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        System.out.println(toFindUniqueBinaryTree.buildTree(inorder, postorder));
    }
}

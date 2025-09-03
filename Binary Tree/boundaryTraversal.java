import java.util.ArrayList;
import java.util.List;

public class boundaryTraversal {
    int data;
    boundaryTraversal left;
    boundaryTraversal right;
    boundaryTraversal(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public static boolean isLeaf(boundaryTraversal root){
        return root.left == null && root.right == null;
    }

    public static void addLeftBoundary(boundaryTraversal root, List<Integer> ans){
        boundaryTraversal curr = root.left;
        while (curr != null){
            if (!isLeaf(curr)) ans.add(curr.data);
            if (curr.left != null){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
    }

    public static void addLeafNode(boundaryTraversal root, List<Integer> ans){
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if (root.left != null) addLeafNode(root.left, ans);
        if (root.right != null) addLeafNode(root.right, ans);
    }

    public static void addRightBoundary(boundaryTraversal root, List<Integer> ans){
        boundaryTraversal curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null){
            if (!isLeaf(curr)) temp.add(curr.data);
            if (curr.right != null){
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
        for (int i = temp.size()-1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    public static List<Integer> boundaryTraversalInBT(boundaryTraversal root){
        List<Integer> ans = new ArrayList<>();
        //Edge Case
        if (root == null) return ans;

        if (!isLeaf(root)) ans.add(root.data);

        //Left Boundary
        addLeftBoundary(root, ans);
        //Leaf node
        addLeafNode(root, ans);
        //Right Boundary
        addRightBoundary(root, ans);

        return ans;
    }
    public static void main(String[] args) {
        boundaryTraversal node = new boundaryTraversal(5);
        node.left = new boundaryTraversal(1);
        node.right = new boundaryTraversal(2);
        node.left.left = new boundaryTraversal(8);
        node.right.left = new boundaryTraversal(4);
        node.right.right = new boundaryTraversal(5);
        node.left.left.right = new boundaryTraversal(6);
        System.out.println(boundaryTraversalInBT(node));
        System.out.println();
    }
}

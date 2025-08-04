import java.util.ArrayList;
import java.util.List;

class tree{
    int data;
    tree left, right;
    tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class rightViewFinder{
    public static void helper(tree root, List<Integer> arrayList, int level){
        if (root == null) return;
        if (arrayList.size() == level){
            arrayList.add(root.data);
        }
        helper(root.right, arrayList, level+1);
        helper(root.left, arrayList, level+1);
    }
    public static List<Integer> function(tree root){
        List<Integer> arrayList = new ArrayList<>();
        helper(root, arrayList, 0);
        return arrayList;
    }
}
public class rightSideView {
    public static void main(String[] args) {
        tree root = new tree(1);
        root.left = new tree(2);
        root.right = new tree(3);
        root.right.right = new tree(4);
        root.left.right = new tree(5);


        System.out.println(rightViewFinder.function(root));
    }
}

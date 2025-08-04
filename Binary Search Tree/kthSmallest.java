import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode1{
    int val;
    TreeNode1 left, right;

    TreeNode1(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class brute{
    public static void helper(TreeNode1 root, List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
    public static int bruteApproach(TreeNode1 root, int k){
        //step 1.
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        //Sort the list...
        Collections.sort(list);

        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            cnt++;
            if (k == cnt){
                ans = list.get(i);
            }
        }
        return ans;
    }
}

class better{
    public static void helperBetter(TreeNode1 root, List<Integer> list){
        if (root == null) return;
        helperBetter(root.left, list);
        list.add(root.val);
        helperBetter(root.right, list);
    }
    public static int betterApproach(TreeNode1 root, int k) {
        //step 1.
        List<Integer> list = new ArrayList<>();
        helperBetter(root, list);

        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            cnt++;
            if (k == cnt) {
                ans = list.get(i);
            }
        }
        return ans;
    }
}

class optimal{
    public static int optimalApproach(TreeNode1 root){
        
        return -1;
    }
}
public class kthSmallest {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(3);
        root.left.left = new TreeNode1(2);
        root.left.right = new TreeNode1(4);
        root.right = new TreeNode1(6);
        root.right.right = new TreeNode1(7);

        System.out.println(better.betterApproach(root, 0));
    }
}

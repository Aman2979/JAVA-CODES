class Node3{
    int val;
    Node3 left, right;

    Node3(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class insertBTS{
    public static Node3 insertFun(Node3 root, int val){
        if (root == null) return new Node3(val);
        Node3 curr = root;
        while (true){
            if (curr.val <= val){
                if (curr.right != null){
                    curr = curr.right;
                }else {
                    curr.right = new Node3(val);
                    break;
                }
            }else {
                if (curr.left != null) {
                    curr = curr.left;
                }else {
                    curr.left = new Node3(val);
                    break;
                }
            }
        }
        return root;
    }
}
public class insertIntoBTS {
    public static void main(String[] args) {
        Node3 root = new Node3(4);
        root.left = new Node3(2);
        root.left.left = new Node3(1);
        root.left.right = new Node3(3);
        root.right = new Node3(7);
        int val = 5;
        System.out.println(insertBTS.insertFun(root, val));
    }
}

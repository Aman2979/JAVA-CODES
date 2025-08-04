class Node2{
    int data;
    Node2 left, right;

    Node2(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class floorInBTS {
    public static int findFloor(Node2 root, int x){
        if (root == null) return -1;
        int ans = -1;
        while (root != null){
            if (x == root.data){
                ans = root.data;
                return ans;
            }

            if (x > root.data){
                ans = root.data;
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Node2 root = new Node2(8);
        root.left = new Node2(3);
        root.left.left = new Node2(1);
        root.left.right = new Node2(6);
        root.left.right.left = new Node2(4);
        root.left.right.right = new Node2(7);
        root.right = new Node2(10);
        root.right.right = new Node2(14);
        int x = 5;
        System.out.println(findFloor(root, x));
    }
}

class Node1{
    int data;
    Node1 left, right;

    Node1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class tempClass{
    public static int findCiel(Node1 root, int key){
        if (root == null) return -1;
        int ciel = -1;
        while (root != null){
            if (key == root.data){
                ciel = root.data;
                return ciel;
            }

            if (key > root.data){
                root = root.right;
            }else {
                ciel = root.data;
                root = root.left;
            }
        }
        return ciel;
    }
}
public class findTheCielValue {
    public static void main(String[] args) {
        Node1 root = new Node1(8);
        root.left = new Node1(3);
        root.left.left = new Node1(1);
        root.left.right = new Node1(6);
        root.left.right.left = new Node1(4);
        root.left.right.right = new Node1(7);
        root.right = new Node1(10);
        root.right.right = new Node1(14);
        int key = 9;

        System.out.println(tempClass.findCiel(root, key));
    }
}

import java.util.*;

public class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

    public static Node listToBST(List<Integer> list) {
        Node tempRoot = new Node(list.get(0));
        Node temp = null;
        for (int i = 1; i < list.size(); i++) {
            insert(tempRoot, list.get(i));
        }
        return tempRoot;
    }
    private static void insert(Node root, int val) {
        Node temp = root;
        while (true) {
            if (val < temp.data) {
                if (temp.left == null) {
                    temp.left = new Node(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new Node(val);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public static Node sumOfNode(Node root, int l, int r){
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.data >= l && node.data <= r){
                list.add(node.data);
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return listToBST(list);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(20);
        root.left.right = new Node(1);

        root.right = new Node(10);
        root.right.right = new Node(-25);
        root.right.right.right = new Node(4);
        root.right.right.left = new Node(3);
        System.out.println(sumOfNode(root, 10, 20));
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class checker{
    public static boolean isIdenticalOrNot(Node root1, Node root2){
        // Base case: if both trees are null, they are identical
        if (root1 == null && root2 == null) return true;
        // If one tree is null and the other is not, they are not identical
        if (root1 == null || root2 == null) return false;

        if ((root1.data == root2.data) &&
                isIdenticalOrNot(root1.left, root2.left) &&
                isIdenticalOrNot(root1.right, root2.right)){
            return true;
        }
        return false;
    }
}
public class identicalOrNot {
    public static void main(String[] args) {
        //First tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        //Second tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);


        boolean answer = checker.isIdenticalOrNot(root1, root2);
        System.out.println(answer);
    }
}

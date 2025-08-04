public class maxDepth {
    int data;
    maxDepth left;
    maxDepth right;

    maxDepth(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static int findMaxiDepth(maxDepth root){
        if (root == null) return 0;
        int lh = findMaxiDepth(root.left);
        int rh = findMaxiDepth(root.right);
        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        maxDepth root = new maxDepth(1);
        root.left = new maxDepth(2);
        root.right = new maxDepth(3);
        root.left.left = new maxDepth(4);
        root.left.right = new maxDepth(5);
        root.right.left = new maxDepth(6);
        root.right.right = new maxDepth(7);

        int answer = findMaxiDepth(root);
        System.out.println(answer);
    }
}

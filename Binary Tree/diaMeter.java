public class diaMeter {
    int data;
    diaMeter left;
    diaMeter right;

    diaMeter(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static int height(diaMeter root, int [] Diameter){
        if (root == null) return 0;
        int lh = height(root.left, Diameter);
        int rh = height(root.right, Diameter);
        Diameter[0] = Math.max(Diameter[0], lh+rh);
        return 1 + Math.max(lh, rh);
    }
    public static int findDiameter(diaMeter root){
        int [] Diameter = new int[1];
        height(root, Diameter);
        return Diameter[0];
    }
    public static void main(String[] args) {
        diaMeter root = new diaMeter(1);
        root.left = new diaMeter(2);
        root.right = new diaMeter(3);
        root.left.left = new diaMeter(4);
        root.left.right = new diaMeter(5);
        root.right.left = new diaMeter(6);
        root.right.right = new diaMeter(7);

        int answer = findDiameter(root);
        System.out.println(answer);
    }
}

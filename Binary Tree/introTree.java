public class introTree {
    int data;
    introTree left;
    introTree right;

    introTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }


    public static void main(String[] args) {
        introTree root = new introTree(1);
        root.left = new introTree(2);
        root.right = new introTree(3);
        root.left.left = new introTree(4);
    }
}

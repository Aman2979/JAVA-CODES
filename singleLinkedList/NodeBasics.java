public class NodeBasics {
    int data;
    NodeBasics next;

        NodeBasics(int data, NodeBasics next) {
        this.data = data;
        this.next = next;
    }

        NodeBasics(int data) {
        this.data = data;
        next = null;
    }

    public static void main(String[] args) {
        int [] arr = {2, 3, 6, 8};
        NodeBasics y = new NodeBasics(arr[2]);
        System.out.println(y.data);
    }
}

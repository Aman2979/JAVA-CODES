public class any {
    int data;
    any next;

    public any(int data) {
        this.data = data;
        next = null;
    }

    public static void main(String[] args) {
        any head = new any(1);
        head.next = new any(2);
        head.next.next = new any(3);
        head.next.next.next = new any(4);
    }
}

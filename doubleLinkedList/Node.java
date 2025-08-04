public class Node {
    int data;
    Node next;
    Node back;

    public Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    public Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }

    public static Node arrayToDLL(int []arr){
       Node head = new Node(arr[0]);
       Node previous = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, previous);
            previous.next = temp;
            previous = temp;
        }
        return head;
    }

    public static void printDLL(Node head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int []arr = {2, 3, 5, 6, 8};
        Node head = arrayToDLL(arr);
        printDLL(head);
    }
}

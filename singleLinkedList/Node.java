public class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        next = null;
    }

    public static Node convertArrayIntoLinkedList(int []arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int [] arr = {222, 3, 6, 8};
        NodeBasics y = new NodeBasics(arr[2]);
        Node head = convertArrayIntoLinkedList(arr);
        System.out.println(head.data);
    }
}

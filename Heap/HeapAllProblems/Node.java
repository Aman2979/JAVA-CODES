import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
    public static Node arrayToList(List<Integer> arr){
        Node newHead = new Node(arr.get(0));
        Node temp = newHead;
        for (int i = 1; i < arr.size(); i++) {
            temp.next = new Node(arr.get(i));
            temp = temp.next;
        }
        return newHead;
    }
    public static Node swapKthNode(Node head, int k){
        if (head == null || head.next == null) return head;
        List<Integer> arr = new ArrayList<>();
        Node temp = head;
        while (temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }

        //Swap
        int tmp = arr.get(k-1);
        arr.set(k-1, arr.get(arr.size()-k));
        arr.set(arr.size()-k, tmp);

        //Array to List
        Node newHead = arrayToList(arr);;
        return newHead;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        int k = 1;

        Node newhead = swapKthNode(head, k);
        while (newhead != null){
            System.out.print(newhead.data+" ");
            newhead = newhead.next;
        }
    }
}

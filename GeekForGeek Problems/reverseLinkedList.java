import java.util.ArrayList;
import java.util.List;

public class reverseLinkedList {
    int data;
    reverseLinkedList next;

    reverseLinkedList(int data){
        this.data = data;
        this.next = null;
    }

    public static void printTheLinkedList(reverseLinkedList head){
        reverseLinkedList temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static reverseLinkedList reverseFunction(reverseLinkedList head){
        List<Integer> tempList = new ArrayList<>();
        reverseLinkedList temp = head;
        while (temp != null){
            tempList.add(temp.data);
            temp = temp.next;
        }

        reverseLinkedList newHead = new reverseLinkedList(tempList.get(tempList.size()-1));
        reverseLinkedList temp1 = newHead;
        for (int i = tempList.size()-2; i >= 0; i--) {
            temp1.next = new reverseLinkedList(tempList.get(i));
            temp1 = temp1.next;
        }
        temp1.next = null;
        return newHead;
    }

    public static reverseLinkedList Optimal(reverseLinkedList head){
        reverseLinkedList temp = head;
        reverseLinkedList prev = null;
        while (temp != null){
            reverseLinkedList front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public static void main(String[] args) {
        reverseLinkedList head = new reverseLinkedList(1);
        head.next = new reverseLinkedList(2);
        head.next.next = new reverseLinkedList(3);
        head.next.next.next = new reverseLinkedList(4);

        System.out.println("Original Linked List:");
        printTheLinkedList(head);

        reverseLinkedList answer = Optimal(head);

        System.out.println("Reversed Linked List:");
        printTheLinkedList(answer);
    }
}

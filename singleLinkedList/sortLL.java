import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortLL {
    int data;
    sortLL next;

    public sortLL(int data, sortLL next) {
        this.data = data;
        this.next = next;
    }

    public sortLL(int data) {
        this.data = data;
        next = null;
    }

    public static sortLL convertArrayIntoLinkedList(int []arr) {
        sortLL head = new sortLL(arr[0]);
        sortLL mover = head;
        for (int i = 1; i < arr.length; i++) {
            sortLL temp = new sortLL(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static sortLL sortTheLL(sortLL head){
        List<Integer> list = new ArrayList<>();
        sortLL temp = head;
        while (temp != null){
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = head;
        int i = 0;
        while (temp != null){
            temp.data = list.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }

    public static void printLL(int []arr, sortLL head){
        sortLL temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 4};
        sortLL y = new sortLL(arr[2]);
        sortLL head = convertArrayIntoLinkedList(arr);

        head = sortTheLL(head);
        printLL(arr, head);
    }
}


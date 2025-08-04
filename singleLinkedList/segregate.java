import java.util.ArrayList;
import java.util.List;

public class segregate {
    int data;
    segregate next;

    public segregate(int data, segregate next) {
        this.data = data;
        this.next = next;
    }

    public segregate(int data) {
        this.data = data;
        next = null;
    }

    public static segregate convertArrayIntoLinkedList(int []arr){
        segregate head = new segregate(arr[0]);
        segregate mover = head;
        for (int i = 1; i < arr.length; i++){
            segregate temp = new segregate(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

//    Brute force Solution...TC O(2n)...SC O(n).
    public static segregate segregateOfOddOrEvenLL(segregate head){
        if (head == null && head.next ==null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        segregate temp = head;
        while (temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null){
            list.add(temp.data);
        }

        temp = head.next;
        while (temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null){
            list.add(temp.data);
        }

        int i = 0;
        temp = head;
        while (temp != null){
            temp.data = list.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }

//    Optimal Solution...
    public static segregate segregateOfOddOrEvenLL2(segregate head){
        if(head == null || head.next == null){
            return head;
        }
        segregate odd = head;
        segregate even = head.next;
        segregate evenHead = head.next;
        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }



    public static void printLL(int []arr, segregate head){
        segregate temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        segregate y = new segregate(arr[2]);
        segregate head = convertArrayIntoLinkedList(arr);

        head = segregateOfOddOrEvenLL2(head);

        printLL(arr, head);
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mergeLL {
    int data;
    mergeLL next;

    public mergeLL(int data, mergeLL next) {
        this.data = data;
        this.next = next;
    }

    public mergeLL(int data) {
        this.data = data;
        next = null;
    }

    public static mergeLL convertArrayIntoLinkedList(List<Integer> arrayList) {
        mergeLL head = new mergeLL(arrayList.get(0));
        mergeLL mover = head;
        for (int i = 1; i < arrayList.size(); i++) {
            mergeLL temp = new mergeLL(arrayList.get(i));
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static mergeLL mergeTwoSortedLL(mergeLL list1, mergeLL list2){
        List<Integer> arrayList = new ArrayList<>();
        mergeLL temp1 = list1;
        while (temp1 != null){
            arrayList.add(temp1.data);
            temp1 = temp1.next;
        }

        mergeLL temp2 = list2;
        while (temp2 != null){
            arrayList.add(temp2.data);
            temp2 = temp2.next;
        }
        Collections.sort(arrayList);

        mergeLL head = convertArrayIntoLinkedList(arrayList);

        return head;
    }

    public static void print(mergeLL head){
        mergeLL temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        mergeLL list1 = new mergeLL(2);
        list1.next = new mergeLL(1);
        list1.next.next = new mergeLL(7);

        mergeLL list2 = new mergeLL(9);
        list2.next = new mergeLL(2);
        list2.next.next = new mergeLL(4);

        mergeTwoSortedLL(list1,list2);
        print(list1);
    }
}

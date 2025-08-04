import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class flatten {
    int data;
    flatten next;
    flatten bottom;

    flatten(int data){
        this.data = data;
        this.next = null;
        this.bottom = null;
    }


    public static flatten sortedForm(flatten head){
        List<Integer> list = new ArrayList<>();
        flatten temp = head;
        while (temp != null){
            flatten bottomTemp = temp;
            while (bottomTemp != null){
                list.add(bottomTemp.data);
                bottomTemp = bottomTemp.bottom;
            }
            temp = temp.next;
        }

        Collections.sort(list);

        flatten newHead = new flatten(list.get(0));
        flatten current = newHead;
        for (int i = 1; i < list.size(); i++) {
            current.next = new flatten(list.get(i));
            current = current.next;
        }
        return newHead;
    }


    public static flatten merge(flatten list1, flatten list2){
        flatten dummyNode = new flatten(-1);
        flatten res = dummyNode;
        while (list1 != null && list2 != null){
            if (list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        // Attach remaining nodes
        if (list1 != null) res.bottom = list1;
        else res.bottom = list2;

        return dummyNode.bottom;
    }
    public static flatten flattenList(flatten head){
        if (head == null || head.next == null) return head;

        // Recursively flatten the rest of the list
        head.next = flattenList(head.next);

        // Merge current list with the next flattened list
        return merge(head, head.next);
    }

    public static void print(flatten head){
        flatten temp = head;
        while (temp != null){
            flatten bottomTemp = temp;
            while (bottomTemp != null){
                System.out.print(bottomTemp.data+" ");
                bottomTemp = bottomTemp.bottom;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        flatten head = new flatten(5);
        //First Node Bottom Element.
        head.bottom = new flatten(7);
        head.bottom.bottom = new flatten(8);
        head.bottom.bottom.bottom = new flatten(30);

        head.next = new flatten(10);
        //Second Node Bottom Element.
        head.next.bottom = new flatten(20);

        head.next.next = new flatten(19);
        //Third Node Bottom Element.
        head.next.next.bottom = new flatten(22);
        head.next.next.bottom.bottom = new flatten(50);

        head.next.next.next = new flatten(28);
        //Fourth Node Bottom Element.
        head.next.next.next.bottom = new flatten(35);
        head.next.next.next.bottom.bottom = new flatten(40);
        head.next.next.next.bottom.bottom.bottom = new flatten(45);

        flatten ans = flattenList(head);
        print(ans);
    }
}

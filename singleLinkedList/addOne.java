import java.util.Stack;

public class addOne {
    int data;
    addOne next;

    addOne(int data, addOne next) {
        this.data = data;
        this.next = next;
    }

    addOne(int data) {
        this.data = data;
        next = null;
    }

    public static addOne convertArrayIntoLinkedList(int []arr){
        addOne head = new addOne(arr[0]);
        addOne mover = head;
        for (int i = 1; i < arr.length; i++){
            addOne temp = new addOne(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

//    reverse LL
    public static addOne reverseOfTheLL(addOne head){
        addOne temp = head;
        addOne prev = null;
        while (temp != null){
            addOne front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

//    Brute force TC...O(3n)...SC...O(1)
    public static addOne addOneGivenLL(addOne head){
        head = reverseOfTheLL(head);
        addOne temp = head;
        int carry = 1;
        while (temp != null){
            temp.data = temp.data+carry;
            if (temp.data < 10){
                carry = 0;
                break;
            }else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        if (carry == 1){
            addOne newNode = new addOne(1);
            head = reverseOfTheLL(head);
            newNode.next = head;
            return newNode;
        }
        head = reverseOfTheLL(head);
        return head;
    }

//    This the helper function for Optimal Solution...
    public static int helper(addOne temp){
        if (temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data += carry;
        if (temp.data < 10){
            return 0;
        }
        temp.data = 0;
        return 1;
    }

    //    Brute force TC...O(n)...SC...O(n)
    public static addOne addOneGivenLL2(addOne head){
        addOne temp = head;
        int carry = helper(temp);

        if (carry == 1){
            addOne newNode = new addOne(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static void printLL(addOne head){
        addOne temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 6, 9};
        addOne y = new addOne(arr[2]);
        addOne head = convertArrayIntoLinkedList(arr);

        head = addOneGivenLL2(head);

        printLL(head);

    }
}

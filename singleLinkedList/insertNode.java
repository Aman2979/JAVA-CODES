import java.lang.reflect.Type;

public class insertNode {
    int data;
    insertNode next;

    insertNode(int data, insertNode next) {
        this.data = data;
        this.next = next;
    }

    insertNode(int data) {
        this.data = data;
        next = null;
    }

    public static insertNode changeIntoLL(int [] arr){
        insertNode head = new insertNode(arr[0]);
        insertNode mover = head;
        for (int i = 1; i < arr.length; i++) {
            insertNode temp = new insertNode(arr[i]);
            mover.next =  temp;
            mover = temp;
        }
        return head;
    }

//    Type 1...
    public static insertNode insertHead(insertNode head, int value){
        insertNode temp = new insertNode(value,head);
        return temp;
    }


//    Type 2...
    public static insertNode insertTail(insertNode head, int value){
        if(head == null){
            return new insertNode(value);
        }
        insertNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        insertNode newNode = new insertNode(value);
        temp.next =  newNode;
        return head;
}

//  type 3...
    public static insertNode insertKthPosition(insertNode head, int el, int k){
        if(head == null) {
            if (k == 1) {
                return new insertNode(el);
            } else {
                return head;
            }
        }
        if(k == 1){
            return new insertNode(el, head);
        }
        int cnt = 0;
        insertNode temp = head;
        while (temp != null){
            cnt++;
            if(cnt == (k-1)){
                insertNode x = new insertNode(el, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static insertNode  insertBeforeValue(insertNode head, int el, int val) {
        if (head == null) {
            return null;
        }
        if (head.data == val) {
            return new insertNode(el, head);
        }
        insertNode temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                insertNode x = new insertNode(el, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void printLL(int []arr, insertNode head){
        insertNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int []arr = {2, 4, 7, 1, 9};
        insertNode head = changeIntoLL(arr);
//        insertNode temp = head;
//        System.out.println(head.data);
//        System.out.println();

//      Type 1...
//      head = insertHead(head, value);
//      System.out.println(head.data);

//        Type 2....
//        head = insertTail(head, 3);


//        Type 3...
//        head = insertKthPosition(head,10,7);

//        Type 4...
        head = insertBeforeValue(head, 10, 9);


        printLL(arr, head);
    }
}

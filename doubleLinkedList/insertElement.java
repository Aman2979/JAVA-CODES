public class insertElement {
    int data;
    insertElement next;
    insertElement back;

    public insertElement(int data1, insertElement next1, insertElement back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    public insertElement(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }

    public static insertElement arrayToDLL ( int[] arr){
        insertElement head = new insertElement(arr[0]);
        insertElement previous = head;
        for (int i = 1; i < arr.length; i++) {
            insertElement temp = new insertElement(arr[i], null, previous);
            previous.next = temp;
            previous = temp;
        }
        return head;
    }

//    Type 1...
    public static insertElement insertTheValueBeforeHead(insertElement head, int val){
        insertElement newHead = new insertElement(val,head, null);
        head.back = newHead;
        return newHead;
    }

//       Type 2...
    public static insertElement insertTheValueBeforeTail(insertElement head, int val){
        if(head.next == null){
            return insertTheValueBeforeHead(head,val);
        }
        insertElement tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        insertElement prev = tail.back;
        insertElement newNode = new insertElement(val, tail, prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
    }

//       Type 3...
    public static insertElement insertTheValueKthPlace(insertElement head, int k, int val){
        if(k == 1){
            return insertTheValueBeforeHead(head,val);
        }
        insertElement temp = head;
        int cnt = 0;
        while (temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }

        insertElement prev = temp.back;
        insertElement newNode = new insertElement(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

//    Type 4...
    public static void insertBeforeNode(insertElement head, int val){
        insertElement prev = head.back;
        insertElement newNode = new insertElement(val, head, prev);
        prev.next = newNode;
        head.back = newNode;
    }

    public static void printDLL (insertElement head){
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8};
        insertElement head = arrayToDLL(arr);

//        Insert the given value before head.
//        head = insertTheValueBeforeHead(head,10);

//        Insert the given value before tail.
//        head = insertTheValueBeforeTail(head, 12);

//        Insert the given value Kth Place.
//        head = insertTheValueKthPlace(head, 5, 10);

//        Insert the Before the head.
        insertBeforeNode(head.next.next.next, 100);

        printDLL(head);
    }
}

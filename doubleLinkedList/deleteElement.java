public class deleteElement {
    int data;
    deleteElement next;
    deleteElement back;

    public deleteElement(int data1, deleteElement next1, deleteElement back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    public deleteElement(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }

    public static deleteElement arrayToDLL ( int[] arr){
        deleteElement head = new deleteElement(arr[0]);
        deleteElement previous = head;
            for (int i = 1; i < arr.length; i++) {
                deleteElement temp = new deleteElement(arr[i], null, previous);
                previous.next = temp;
                previous = temp;
            }
            return head;
        }

    public static void printDLL (deleteElement head){
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }

//        Type 1...
    public static deleteElement deleteHeadOfTheDLL(deleteElement head){
        if (head == null || head.next == null){
            return null;
        }
        deleteElement previous = head;
        head = head.next;

        head.back = null;
        previous.next = null;
        return head;
    }

//    Type 2...
    public static deleteElement deleteTheTailOfTheDLL(deleteElement head){
        if (head == null || head.next == null){
            return null;
        }
        deleteElement tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        deleteElement prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }

//    Type 3...
    public static deleteElement deleteKthElementInDLL(deleteElement head, int k){
        if(head == null){
            return null;
        }
        int cnt = 0;
        deleteElement kNode = head;
        while (kNode != null){
            cnt++;
            if (cnt == k) break;
            kNode = kNode.next;
        }
        deleteElement prev = kNode.back;
        deleteElement front = kNode.next;

        if(prev == null && front == null){
            return null;
        }
       else if(prev == null){
            return deleteHeadOfTheDLL(head);
        } else if (front == null) {
            return deleteTheTailOfTheDLL(head);
        }
       prev.next = front;
       front.back = prev;

       kNode.next = null;
       kNode.back = null;
        return head;
    }

//    Type 4...
    public static void deleteTheGivenPositionInDLL(deleteElement temp){
        deleteElement prev = temp.back;
        deleteElement front = temp.next;

        if (front == null){
            prev.next = null;
            temp.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        temp.next = temp.back = null;
    }

    public static void main(String[] args) {
        int []arr = {2, 3, 5, 6, 8};
        deleteElement head = arrayToDLL(arr);

//        Delete the head of the DLL
//        head = deleteHeadOfTheDLL(head);

//        Delete the tail of the DLL
//        head = deleteTheTailOfTheDLL(head);

//        Delete the Kth Element of the DLL
//        head = deleteKthElementInDLL(head, 2);

//        Delete the Given Element of the DLL
          deleteTheGivenPositionInDLL(head.next.next);

        printDLL(head);
    }
}
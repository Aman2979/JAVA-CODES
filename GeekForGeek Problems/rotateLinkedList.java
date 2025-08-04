public class rotateLinkedList {
    int data;
    rotateLinkedList next;

    rotateLinkedList(int data){
        this.data = data;
        this.next = null;
    }

    public static rotateLinkedList findNthNode(rotateLinkedList temp, int k){
        int cnt = 1;
        while (temp !=null){
            if (cnt == k) return temp;
            cnt ++;
            temp = temp.next;
        }
        return temp;
    }

    public static void print(rotateLinkedList head){
        rotateLinkedList temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static rotateLinkedList rotate(rotateLinkedList head, int k){
        if (head == null || k == 0){
            return head;
        }

        rotateLinkedList tail = head;
        int len = 1;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }

        if(k % len == 0) return head;

        k = k % len;

        rotateLinkedList newTail = findNthNode(head, k);  // This is the node at position k
        rotateLinkedList newHead = newTail.next;  // This will be the new head

        // Connect the end of the list to the current head to make it circular temporarily
        tail.next = head;

        // Break the circle and make the newTail the last node
        newTail.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        rotateLinkedList head = new rotateLinkedList(10);
        head.next = new rotateLinkedList(20);
        head.next.next = new rotateLinkedList(30);
        head.next.next.next = new rotateLinkedList(40);
        head.next.next.next.next = new rotateLinkedList(50);

        int k = 4;

        head = rotate(head, k);

        print(head);
    }
}

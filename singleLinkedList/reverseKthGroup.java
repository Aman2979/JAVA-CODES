public class reverseKthGroup {
    int data;
    reverseKthGroup next;

    reverseKthGroup(int data, reverseKthGroup next) {
            this.data = data;
            this.next = next;
        }

        reverseKthGroup(int data) {
            this.data = data;
            next = null;
        }

    public static reverseKthGroup reverseOfTheLL(reverseKthGroup head){
        reverseKthGroup temp = head;
        reverseKthGroup prev = null;
        while (temp != null){
            reverseKthGroup front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static reverseKthGroup findKthGroup(reverseKthGroup temp, int k){
        k -= 1;
        while (temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static reverseKthGroup reverseKthGroupLL(reverseKthGroup head, int k){
        if (head == null || k == 1) {
            return head;
        }

        reverseKthGroup temp  = head;
        reverseKthGroup prevLast = null;
        while (temp != null){
            reverseKthGroup kthNode = findKthGroup(temp, k);
            if(kthNode == null){
                if (prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }
            reverseKthGroup nextNode = kthNode.next;
            kthNode.next =  null;
            reverseOfTheLL(temp);
            if (temp == head){
                head = kthNode;
            }else {
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    public static void print(reverseKthGroup head){
        reverseKthGroup temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        int k = 3;
        reverseKthGroup head = new reverseKthGroup(1);
        head.next = new reverseKthGroup(2);
        head.next.next = new reverseKthGroup(3);
        head.next.next.next = new reverseKthGroup(4);
        head.next.next.next.next = new reverseKthGroup(5);
        head.next.next.next.next.next = new reverseKthGroup(6);
        head.next.next.next.next.next.next = new reverseKthGroup(7);

        head = reverseKthGroupLL(head, k);

        print(head);
    }
}

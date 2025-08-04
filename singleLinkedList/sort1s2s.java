public class sort1s2s {
    int data;
    sort1s2s next;

    public sort1s2s(int data) {
        this.data = data;
        next = null;
    }

    public static sort1s2s sortLL(sort1s2s head){
        sort1s2s temp = head;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        while (temp != null){
            if (temp.data == 0) cnt0++;
            else if(temp.data == 1) cnt1++;
            else cnt2++;
            temp = temp.next;
        }
        temp = head;
        while (temp != null){
            if(cnt0 != 0){
                temp.data = 0;
                cnt0--;
            } else if (cnt1 != 0) {
                temp.data = 1;
                cnt1--;
            }else {
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }
        return head;
    }

    public static sort1s2s sortLL2(sort1s2s head){
        sort1s2s zeroHead = new sort1s2s(-1);
        sort1s2s oneHead = new sort1s2s(-1);
        sort1s2s twoHead = new sort1s2s(-1);

        sort1s2s zero = zeroHead;
        sort1s2s one = oneHead;
        sort1s2s two = twoHead;

        sort1s2s temp = head;
        while (temp != null){
            if (temp.data==0){
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            }else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

//        if (zeroHead.next != null){
//            zero.next = one.next;
//            one.next = two.next;
//        } else if (oneHead.next != null) {
//            one.next = two.next;
//        }else {
//            two.next = null;
//        }

        sort1s2s newHead = zeroHead.next;
        return newHead;
    }

    public static void printLL(sort1s2s head){
        sort1s2s temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        sort1s2s head = new sort1s2s(1);
        head.next = new sort1s2s(2);
        head.next.next = new sort1s2s(1);
        head.next.next.next = new sort1s2s(1);
        head.next.next.next.next = new sort1s2s(2);
        head.next.next.next.next.next = new sort1s2s(1);
        head.next.next.next.next.next.next = new sort1s2s(0);

        head = sortLL2(head);

        printLL(head);
    }
}

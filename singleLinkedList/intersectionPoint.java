import java.util.HashMap;
import java.util.HashSet;

public class intersectionPoint {
    int data;
    intersectionPoint next;

    public intersectionPoint(int data, intersectionPoint next) {
        this.data = data;
        this.next = next;
    }

    public intersectionPoint(int data) {
        this.data = data;
        this.next = null;
    }

    public static intersectionPoint intersectionPointFind(intersectionPoint head, intersectionPoint headSec){
        HashSet<intersectionPoint> mpp = new HashSet<>();
        while (head != null){
            mpp.add(head);
            head = head.next;
        }

        while (headSec != null){
            if (mpp.contains(headSec)) return headSec;
            headSec = headSec.next;
        }
        return null;
    }

    public static intersectionPoint intersectionPointFind2(intersectionPoint head, intersectionPoint headSec){

        return null;
    }

    public static void main(String[] args) {
        intersectionPoint head = null;
        head= new intersectionPoint(1,head);
        head= new intersectionPoint(3,head);
        head= new intersectionPoint(1,head);
        head= new intersectionPoint(2,head);
        head= new intersectionPoint(4,head);
        intersectionPoint head1 = head;
        head = head.next.next.next;
        intersectionPoint headSec = null;

        headSec= new intersectionPoint(3, headSec);
        intersectionPoint head2 = headSec;
        headSec.next = head;

        intersectionPoint ans = intersectionPointFind(head, headSec);
        System.out.println(ans.data);

    }
}
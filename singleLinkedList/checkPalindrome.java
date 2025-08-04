import java.util.Stack;

public class checkPalindrome {
    int data;
    checkPalindrome next;

    public checkPalindrome(int data, checkPalindrome next) {
        this.data = data;
        this.next = next;
    }

    public checkPalindrome(int data) {
        this.data = data;
        next = null;
    }

    public static checkPalindrome convertArrayIntoLinkedList(int []arr){
        checkPalindrome head = new checkPalindrome(arr[0]);
        checkPalindrome mover = head;
        for (int i = 1; i < arr.length; i++){
            checkPalindrome temp = new checkPalindrome(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

//    Brute force TC O(2N)  SC O(N)
    public static boolean isPalindrome(checkPalindrome head){
        Stack<Integer> st = new Stack<>();
        checkPalindrome temp = head;
        while (temp != null){
            st.push(head.data);   //Step 1.
            temp = temp.next;
        }
         temp = head;
        while (temp != null){
            if (temp.data != st.peek()){
                return false;
            }
            st.pop();
            temp = temp.next;
        }
        return false;
    }

    public static checkPalindrome reverseOfTheLL(checkPalindrome head) {
        if (head == null || head.next == null) return head;
        checkPalindrome newHead = reverseOfTheLL(head.next);
        checkPalindrome front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static boolean isPalindromeOrNot(checkPalindrome head){
        if (head == null || head.next == null) return true;
        checkPalindrome slow = head;
        checkPalindrome fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast =  fast.next.next;
        }

        checkPalindrome newHead = reverseOfTheLL(slow.next);
        checkPalindrome first = head;
        checkPalindrome second = newHead;
        while (second != null){
            if (first.data != second.data){
                reverseOfTheLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseOfTheLL(newHead);
        return true;
    }

    public static void printLL(int []arr, checkPalindrome head){
        checkPalindrome temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 2, 1, 9};
        checkPalindrome y = new checkPalindrome(arr[2]);
        checkPalindrome head = convertArrayIntoLinkedList(arr);

        Boolean ans = isPalindromeOrNot(head);
        System.out.println(ans);

//        printLL(arr, head);
    }
}

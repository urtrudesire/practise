package code;

public class ReverseLinkedList {

    /**
     *Given the head of a singly linked list, reverse the list, and return the reversed list.
     */


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

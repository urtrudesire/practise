package code;

public class SwapNodesInPair {

    public ListNode swapPairs(ListNode head) {
        if(head.next == null)
            return head;
        ListNode start = head.next;
        ListNode temp = start.next;
        ListNode first = head;
        ListNode second = head.next;
        second.next = first;
        first.next = temp;
        ListNode prev = first;
        first = first.next;
        while(first != null && first.next !=null){
            second = first.next;
            temp = second.next;
            prev.next = second;
            second.next = first;
            first.next = temp.next;
            prev = first;
            first = first.next;
        }
        return start;
    }
}

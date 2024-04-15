package Code;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode start = head;
         int size = 0;
         while(head != null){
             head = head.next;
             size++;
         }
         head = start;
         n = size + 1 - n;
         if( n == 1){
             return start.next;
         }
         ListNode prev = null;
         while (n != 1){
             prev = head;
             head = head.next;
             n--;
         }
         prev.next = head.next;
         return start;
    }
}

package code;

public class RemoveLoopLinkedList {

    public static void removeLoop(ListNode head){
        // code here
        // remove the loop without losing any nodes
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                removeLoopNode(slow, head);
                return;
            }
        }
    }

    static void removeLoopNode(ListNode loop, ListNode head){
        int k = 1;
        ListNode prevNode = loop, n2 = loop;
        while(n2.next != loop){
            prevNode = n2;
            n2 = n2.next;
            k++;
        }
        loop = head;
        n2 = head;
        for(int i =1; i < k; i++){
            n2 = n2.next;
        }
        while(n2.next != loop){
            loop = loop.next;
            n2 = n2.next;
        }
        n2.next = null;
    }

    public static void main(String[] args)
    {

        ListNode node = new ListNode(7);
        node.next = new ListNode(58);
        node.next.next = new ListNode(36);
        node.next.next.next = new ListNode(34);
        node.next.next.next.next = new ListNode(16);
        node.next.next.next.next.next = node;

        // Creating a loop for testing
        removeLoop(node);
    }
}

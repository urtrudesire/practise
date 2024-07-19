package code;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode start = null, current = null;
         while (list1 != null && list2 != null){
             ListNode node;
             if(list1.val > list2.val){
                 node = new ListNode(list2.val);
                 list2 = list2.next;
             } else {
                 node = new ListNode(list1.val);
                 list1 = list1.next;
             }
             if (null == start){
                 start = node;
                 current = node;
             } else {
                 current.next = node;
                 current = current.next;
             }
         }
         if (current == null){
             if(list1 !=null)
                 return list1;
             else
                 return list2;
         }
         if(list1 != null){
             current.next = list1;
         } else {
             current.next = list2;
         }

        return start;
    }
}

package Code;

public class LinkedListSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode res = new ListNode();
          ListNode start = res;
          int carry = 0;
          while(l1 != null && l2 != null){
              res.next = new ListNode();
              res = res.next;
              int sum = l1.val + l2.val + carry;
              if(sum > 9){
                  carry = 1;
                  sum = sum%10;
              }else {
                  carry = 0;
              }
              res.val = sum;
              res.next = null;
              l1 = l1.next;
              l2 = l2.next;
          }
          if(l1 != null){
              addRemaining(res, l1, carry);
          } else if (l2 != null){
              addRemaining(res, l2, carry);
          }
          return start.next;
    }

    private void addRemaining(ListNode res, ListNode l1, int carry) {
          while (l1 != null){
              res.next = new ListNode();
              res = res.next;
              int sum = l1.val + carry;
              if(sum > 9){
                  sum %= 10;
                  carry = 1;
              } else {
                  carry = 0;
              }
              res.val = sum;
              res.next = null;
              l1 = l1.next;
          }
          if(carry > 0){
              res.next = new ListNode(1, null);
          }
    }
}

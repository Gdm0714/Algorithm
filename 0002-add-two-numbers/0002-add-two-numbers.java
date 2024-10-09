/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode l3 = new ListNode(0);
          ListNode result = l3;
          int carry = 0;
          while(l1 != null || l2 != null || carry != 0){
            int numA = 0, numB = 0;
            if(l1 != null) {
                numA = l1.val;
                l1 = l1.next;
                }
            if(l2 != null){
                numB = l2.val;
                l2 = l2.next;
            }

            int sum = numA + numB + carry;
            int di = sum % 10;
            carry = sum / 10;
            System.out.println(di);
            l3.next = new ListNode(di);
            l3 = l3.next;
          }
          return result.next;
    }
}
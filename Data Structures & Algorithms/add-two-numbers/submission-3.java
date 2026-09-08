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
        if (l1.val == 0 && l2.val == 0) {
            return l1;
        } else if (l1.val == 0 && l2.val != 0) {
            return l2;
        } else if (l1.val != 0 && l2.val == 0) {
            return l1;
        }

        // carry implementation
        
        // getting summed linked list
        int carry = 0;
        int result = 0;
        
        ListNode curr = null;
        ListNode prev = null;
        while (l1 != null || l2 != null || carry != 0) {
            int l = l1 != null ? l1.val : 0;
            int r = l2 != null ? l2.val : 0;
            result = l + r + carry;
            
            curr = new ListNode((result > 9 ? (result % 10) : result), prev);
            prev = curr;
            carry = 0;
            if (result > 9) {
                carry = result / 10;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        // reversing summed linked list
        l1 = null;
        l2 = curr;
        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = temp;
        }

        return l1;
    }
}

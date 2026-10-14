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
    public boolean isPalindrome(ListNode head) {
        ListNode fast, mid, slow;

        // getting the middle point
        fast = head;
        mid = fast;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }

        // reversing the second half of the linked list
        ListNode prev = null;
        ListNode curr = mid;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        // ArrayList<Integer> arr = new ArrayList<>();
        //     arr.add(curr.val);
        // System.out.println(arr.toString());

        // checking if they are equals
        slow = head;
        mid = prev;
        while (mid != null) {
            if (slow.val != mid.val) {
                return false;
            }

            slow = slow.next;
            mid = mid.next;
        }

        return true;
    }
}
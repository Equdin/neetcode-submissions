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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // traverse the list till ith position
        // remove the elements between i & j in the list
        // combine all the three lists

        ListNode res = new ListNode(0);
        res.next = list1;
        ListNode curr =  res;

        // get upto ith position node
        for (int i = 0; i < a; i++) {
            curr = curr.next;
        }

        // connect to list2
        ListNode temp = curr.next;
        curr.next = list2;
        curr = temp;

        // remove till jth position
        for (int j = a; j <= b; j++) {
            curr = curr.next;
        }

        while (list2.next != null) {
            list2 = list2.next;
        }

        // connect list2 end to j + 1th position
        list2.next = curr;

        return res.next;
    }
}

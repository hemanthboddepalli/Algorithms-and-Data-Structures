//https://leetcode.com/problems/swap-nodes-in-pairs/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode tempNext = next.next;
            next.next = curr;
            prev.next = next;
            curr.next = tempNext;
            
            prev = curr;
            curr = tempNext;
            next = null;
            if (curr != null) {
                next = curr.next;
            }
        }
        return dummy.next;
    }
}

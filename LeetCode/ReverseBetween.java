//https://leetcode.com/problems/reverse-linked-list-ii/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int i=1;
        while (curr != null && i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode newPrev = prev, newCurr = curr;
        while (i >= m && i <= n) {
            ListNode temp = newCurr.next;
            newCurr.next = newPrev;
            newPrev = newCurr;
            newCurr = temp;
            i++;
        }
        prev.next = newPrev;
        curr.next = newCurr;
        return dummy.next;
    }
}

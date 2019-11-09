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
        int count = 1;
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        ListNode prev = newhead;
        ListNode curr = head;
        while (count < m) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode prevTemp = prev;
        while (count <= n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        ListNode newTail = prevTemp.next;
        newTail.next = curr;
        prevTemp.next = prev;
        return newhead.next;
    }
}

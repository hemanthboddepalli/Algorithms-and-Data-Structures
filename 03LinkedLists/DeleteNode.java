/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode next = node.next;
        while (next.next != null) {
            curr.val = curr.next.val;
            curr = curr.next;
            next = next.next;
        }
        curr.val = curr.next.val;
        curr.next = null;
    }
}

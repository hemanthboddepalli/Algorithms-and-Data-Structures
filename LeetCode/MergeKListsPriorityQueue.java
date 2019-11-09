//https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeKListsPriorityQueue {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((l1, l2) -> (l1.val-l2.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            tail.next = queue.remove();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return head.next;
    }
}

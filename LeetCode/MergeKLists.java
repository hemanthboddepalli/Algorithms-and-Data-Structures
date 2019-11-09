//https://leetcode.com/problems/merge-k-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length-1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        else if (s < e) {
            int q = (s+e)/2;
            ListNode l1 = mergeKLists(lists, s, q);
            ListNode l2 = mergeKLists(lists, q+1, e);
            return mergeKLists(l1, l2);
        }
        else {
            return null;
        }
    }
    
    private ListNode mergeKLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeKLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeKLists(l1, l2.next);
            return l2;
        }
    }
}

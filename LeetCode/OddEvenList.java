//https://leetcode.com/problems/odd-even-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddPointer = head;
        ListNode evenPointer = head.next;
        ListNode evenHead = head.next;
        while (evenPointer != null && evenPointer.next != null) {
            ListNode currOdd = oddPointer.next.next;
            ListNode currEven = evenPointer.next.next;
            oddPointer.next = currOdd;
            evenPointer.next = currEven;
            oddPointer = currOdd;
            evenPointer = currEven;
        }
        oddPointer.next = evenHead;
        return head;
    }
}

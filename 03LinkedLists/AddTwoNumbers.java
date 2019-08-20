/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;        
        ListNode newHead = null, curr = null; int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null) {
                sum = sum + head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum = sum + head2.val;
                head2 = head2.next;
            }
            int digit = sum % 10;
            carry = sum / 10;
            if (newHead == null) {
                newHead = new ListNode(digit);
                curr = newHead;
            }
            else {
                curr.next = new ListNode(digit);
                curr = curr.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return newHead;
    }
}

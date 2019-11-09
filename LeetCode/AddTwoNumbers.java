//https://leetcode.com/problems/add-two-numbers-ii/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        while (l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }        
        while (l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
        }        
        int carry = 0; ListNode curr = null;
        while (!st1.isEmpty() || !st2.isEmpty()) {
            int sum = carry;
            if (!st1.isEmpty()) {
                sum += st1.pop();
            }
            if (!st2.isEmpty()) {
                sum += st2.pop();
            }
            carry = sum / 10;
            ListNode node = new ListNode(sum%10);
            node.next = curr;
            curr = node;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = curr;
            curr = node;
        }
        return curr;
    }
}

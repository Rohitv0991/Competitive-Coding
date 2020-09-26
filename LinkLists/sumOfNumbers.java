/*You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

//https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prev = new ListNode(0);
        ListNode dummy = prev;
        
        while(l1 != null || l2 != null) {
            //get values if present
            int x = (l1 == null)? 0 : l1.val;
            int y = (l2 == null)? 0 : l2.val;
            
            //calculate sum
            int sum = carry + x + y;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            
            //move to next node if exists
            prev = prev.next;
            l1 = (l1 == null)? l1 : l1.next;
            l2 = (l2 == null)? l2 : l2.next;
        }
        
        //add any remaining carry
        if(carry > 0) prev.next = new ListNode(carry);
        
        return dummy.next;
    }
}
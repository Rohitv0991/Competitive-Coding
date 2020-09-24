/*Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. 
The program should run in O(1) space complexity and O(nodes) time complexity.

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
*/

//https://leetcode.com/problems/odd-even-linked-list/

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
    public ListNode oddEvenList(ListNode head) {
        //if 2 or less nodes return head
        if(head == null || head.next == null || head.next.next == null) return head;
        
        ListNode odd = head; 
        ListNode evenHead = head.next;
        ListNode even = head.next;
        
        while(even != null && even.next != null) {
            //make odd list
            odd.next = odd.next.next;
            //make even list
            even.next = even.next.next;
            //move to next node
            odd = odd.next;
            even = even.next;
        }
        
        //add even list at tail of odd list
        odd.next = evenHead;
        return head;
    }
}
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3



############################################ Solution ######################################################################

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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode curr = head;
        
        while(curr!=null){
            
            ListNode temp = curr;
            
            while(temp!=null && temp.val == curr.val){
                
                temp=temp.next;
            }
            
            curr.next = temp;
            curr = temp;
        }
        
        return head;
        
    }
}

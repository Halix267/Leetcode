Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5


###############################################################SOL ####################################################################

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
    public ListNode removeElements(ListNode head, int val) {
        
       while(head!=null && head.val==val)
            head=head.next;
        
        if(head==null)
           return head;
            
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr!=null){
            if(curr.val==val){
                prev.next=curr.next;
                curr=prev.next;
            }else{
                curr=curr.next;
                prev=prev.next;
            }
        }
        return head;
    
    }
}

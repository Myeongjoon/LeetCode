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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode faster = head;
        ListNode prev = null;
        if(head == null){
            return null;
        }else if(head.next == null){
            return null;
        }else if(head.next.next == null){
            head.next = null;
        }
        while(slow!=null && faster!=null && faster.next != null){
            prev = slow;
            slow = slow.next;
            faster = faster.next.next;
        }
        if(slow.next!=null && prev != null){
            prev.next = slow.next;
        }
        return head;
    }
}
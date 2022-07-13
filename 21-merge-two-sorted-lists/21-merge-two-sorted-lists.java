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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = null;
        ListNode current = null;
        ListNode currentA = list1;
        ListNode currentB = list2;
        while(list1!=null && list2 != null){
            ListNode next = null;
            if(list1.val > list2.val){
                next = list2;
                list2 = list2.next;
            }else{
                next = list1;
                list1 = list1.next;
            }
            if(root == null){
                root = next;
                current = root;
            }else{
                current.next = next;
                current = next;
            }
        }
        while(list1!=null){
            if(root == null){
                root = list1;
                current = list1;
            }else{
                current.next = list1;
                current = current.next;
            }
            list1 = list1.next;
        }
        while(list2!=null){
            if(root == null){
                root = list2;
                current = list2;
            }else{
                current.next = list2;
                current = current.next;
            }
            list2 = list2.next;
        }
        return root;
    }
}
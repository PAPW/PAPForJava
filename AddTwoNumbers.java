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
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        boolean flag = false;
        int a = 0;
        while(true){
            if(l1 == null && l2 == null){
                break;
            }
            if(l1 != null && l2 != null){
                a = l1.val + l2.val;
            }else if(l1 != null && l2 == null){
                a = l1.val;
            }else if(l1 == null && l2 != null){
                a = l2.val;
            }
            if(flag == true){
                a = a + 1;
                flag = false;
            }
            if(a >= 10){
                a = a - 10;
                flag = true;
            }
            ListNode b = new ListNode(a);
            temp.next = b;
            temp = temp.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(flag == true){
            temp.next = new ListNode(1);
            flag = false;
        }
        return l3.next;
    }
}
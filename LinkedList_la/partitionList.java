package LinkedList_la;

import utils.ListNode;

public class partitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy, prev = dummy;
        prev.next = head;
        ListNode q = head;
        while(q!= null && q.val < x){
            p.next = q;
            prev = prev.next;
            p = p.next;
            q = q.next;

        }
        ListNode cur = q;
        while(q!=null){
            if(q.val >= x){
                q = q.next;
                prev = prev.next;
            }else{
                p.next = prev.next;
                prev.next = q.next;
                q = prev.next;
                p = p.next;
            }
        }
        p.next = cur;
        // System.out.println("yes");
        return dummy.next;
    }
}

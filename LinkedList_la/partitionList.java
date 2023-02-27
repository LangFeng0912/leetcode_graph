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

    // 合并链表的方法，但是要记得断开原序列的next
    public ListNode partition1(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur = head;
        ListNode l1 = dummy1;
        ListNode l2 = dummy2;
        while(cur != null){
            if(cur.val<x){
                l1.next = cur;
                l1 = l1.next;
            }else{
                l2.next = cur;
                l2 = l2.next;
            }
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        l1.next = dummy2.next;
        return dummy1.next;
    }

}

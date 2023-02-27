package LinkedList_la;

import utils.ListNode;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode p1 = head, p2 = head;
        while(p2 != null){
            if(p2.next == null){
                // p1 = p1.next;
                return p1;
            }
            p2 = p2.next.next;
            p1 = p1.next;
        }
        return p1;


    }
}

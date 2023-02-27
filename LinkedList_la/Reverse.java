package LinkedList_la;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode p =head;
        Deque<ListNode> stack = new LinkedList<>();
        while(p!=null){
            stack.push(p);
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        ListNode dummy = new ListNode(-1);
        ListNode q = dummy;
        while(!stack.isEmpty()){
            q.next = stack.poll();
            q = q.next;
        }

        return dummy.next;
    }
}

package LinkedList_la;

import utils.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveKfromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<ListNode> que = new LinkedList<>();
        ListNode p = head;
        int count = 0;
        while(p!=null){
            que.offer(p);
            count ++;
            p = p.next;
        }
        System.out.println(count);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0; i<count-n; i++){
            prev = que.poll();
        }
        if(prev.next != null)
            prev.next = prev.next.next;
        return dummy.next;


    }

}

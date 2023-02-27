package LinkedList_la;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseK {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p  = head;
        ListNode dummy = new ListNode(-1);
        ListNode st = new ListNode(-1);
        ListNode q = dummy;
        Deque<ListNode> stack = new LinkedList<>();
        while(p!=null){
            st = p;
            for(int i = 0; i<k; i++){
                if(p!=null){
                    stack.push(p);
                    p = p.next;
                }
            }
            // System.out.println(p.val);
            if(stack.size() == k){
                int s =stack.size();
                while(s-- > 0){
                    ListNode cur = stack.poll();
                    System.out.println(cur.val);
                    cur.next = null;
                    q.next = cur;
                    q = q.next;
                }
            }else{
                break;
            }
        }
        if(stack.size()!=0){
            q.next = st;
        }

        return dummy.next;
    }
}

package LinkedList_la;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class reverseRange {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = new ListNode(-1);
        ListNode dummy = prev;
        prev.next = head;

        int count = 1;
        while(count <left){
            prev = prev.next;
            count ++;
        }
        ListNode st = prev;
        prev = prev.next;
        Deque<ListNode> stack = new LinkedList<>();
        while(count <= right){
            stack.push(prev);
            prev = prev.next;
            count++;
        }
        ListNode en =  new ListNode(-1);
        if(prev!= null){
            en = prev;
        }else{
            en = null;
        }


        while(!stack.isEmpty()){
            ListNode cur = stack.poll();
            st.next = cur;
            cur.next = null;
            st = st.next;
        }

        System.out.println(st.val);
        st.next = en;


        return dummy.next;
    }
}

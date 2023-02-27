package LinkedList_la;

import utils.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class KfromEn {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Queue<ListNode> que = new LinkedList<>();
        ListNode p = head;
        int count = 0;
        while(p!=null){
            que.offer(p);
            p = p.next;
            count ++;
        }
        ListNode ans = new ListNode();
        for(int i = 0; i<count - k +1; i++){
            ans = que.poll();
        }
        return ans;
    }
}

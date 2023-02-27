package LinkedList_la;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        // System.out.println(lists.length);
        int k = lists.length;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });

        for(int i = 0 ;i<k ;i++){
            ListNode cur = lists[i];
            while(cur != null){
                heap.offer(cur);
                cur = cur.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!heap.isEmpty()){
            ListNode cur1 = heap.poll();
            cur1.next = null;
            p.next = cur1;
            p = p.next;
        }

        return dummy.next;
    }
}

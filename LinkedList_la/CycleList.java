package LinkedList_la;

import utils.ListNode;

import java.util.HashSet;

public class CycleList {

    // 141. 环形链表
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode p1 = head, p2 = head;
        HashSet<ListNode> set = new HashSet<>();
        while(p1 != null){
            if(!set.add(p1)){
                return p1;
            }
            p1 = p1.next;
        }
        return null;
    }

    //一个指针变为根结点，这样再次相遇时位置 为入口位置
    public ListNode detectCycle2(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = head;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p2;
            }
        }
        return null;
    }





}

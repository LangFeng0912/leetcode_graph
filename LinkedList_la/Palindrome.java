package LinkedList_la;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head ,q = head;
        int count = 0;
        while(p!=null){
            p = p.next;
            count ++;
        }
        System.out.println(count);
        if(count ==1) return true;
        Deque<ListNode> stack = new LinkedList<>();
        for(int i =0; i<count/2; i++){
            stack.push(q);
            q = q.next;
        }
        System.out.println(stack.size());
        if(count%2 == 1){
            q = q.next;
        }
        // System.out.println(q.val);
        while(!stack.isEmpty()){
            if(q.val != stack.poll().val){
                return false;
            }
            q = q.next;
        }

        return true;
    }
}

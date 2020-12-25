package LinkList.q206_Reverse_Linked_List;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode tmp=head;
        for (int i = 0; i <5 ; i++) {
            tmp.next = new ListNode(i + 2);
            tmp = tmp.next;
        }
        s.reverseList(head);
    }
    public ListNode reverseList(ListNode head) {

        //迭代
//        if(head==null||head.next==null) return head;
//        Stack<ListNode> s = new Stack<>();
//        while (head != null) {
//            s.push(head);
//            head=head.next;
//        }
//        head = s.pop();
//        ListNode tmp=head;
//        while (!s.isEmpty()) {
//            tmp.next = s.pop();
//            tmp = tmp.next;
//        }
//        tmp.next = null;
//        return head;

        //递归
        if(head==null||head.next==null) return head;
        ListNode p = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
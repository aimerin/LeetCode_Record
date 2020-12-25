package LinkList.q25_Reverse_Nodes_in_k_Group;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        ListNode head=node;
        for (int i = 1; i <4 ; i++) {
            node.next = new ListNode(i + 1, null);
            node=node.next;
        }
        new Solution().reverseKGroup(head, 2);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        ListNode pre=dummy;
        ListNode end = dummy;

        while(end.next!=null){
            for (int i = 0; i < k && end != null; i++) {
                end=end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start=pre.next;
            ListNode next=end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next=next;
            pre=start;

            end=pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
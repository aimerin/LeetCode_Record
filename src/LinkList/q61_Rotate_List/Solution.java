package LinkList.q61_Rotate_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp=head;
        int len=1;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        k = k % len;
        if(k==0)return head;
        ListNode newHead=head,newTail=head;
        for (int i = 0; i < len - k; i++) {
            newHead = newHead.next;
        }
        for (int j = 0; j < len -k- 1; j++) {
            newTail = newTail.next;
        }
        tmp.next=head;
        newTail.next = null;
        return newHead;
    }
}

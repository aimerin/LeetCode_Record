package FastSlowPointer.q876_Middle_of_the_Linked_List;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        if(fast==null)
            return null;
        while (fast!= null) {
            slow=slow.next;
            fast = fast.next != null ? fast.next.next : fast.next;
        }
        return slow;
    }
}

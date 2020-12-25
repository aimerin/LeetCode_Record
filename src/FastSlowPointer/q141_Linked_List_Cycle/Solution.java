package FastSlowPointer.q141_Linked_List_Cycle;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode fast=head!=null?head.next:head;
        ListNode slow=head;
        if(fast==null)
            return false;
        while(fast!=slow){
            fast=fast.next!=null?fast.next.next:fast.next;
            slow=slow.next;
            if(fast==null)
                return false;
        }
        return true;
    }
}
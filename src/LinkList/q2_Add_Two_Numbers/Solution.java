package LinkList.q2_Add_Two_Numbers;
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;    
        ListNode head=null,tail=null;
        while(l1!=null||l2!=null) {
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            int sum=n1+n2+carry;
            if(null==head) {
                head=new ListNode(sum%10,null);
                tail=head;
            }else{
                tail.next=new ListNode(sum%10,null);
                tail=tail.next;
            }
            carry=sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            tail.next=new ListNode(carry,null);
        }
        return head;
    }
}
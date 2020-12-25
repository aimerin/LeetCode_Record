package LinkList.q19_Remove_Nth_Node_From_End_of_List;
//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
 public class Solution{

     public ListNode removeNthFromEnd(ListNode head, int n){ 
        //  //1、暴力求法
        //  //求链表长度
        //  ListNode tail=head;
        //  ListNode cur=head;
        //  int len=0;
         
        //  while(null != tail){ 
        //      len++;
        //      tail=tail.next;
        //  }

        //  //找到第len-n的结点
        //  for(int i=0;i<len-n;i++){
        //     cur=cur.next;
        //  }

        //  //移除结点
        //  cur.next=cur.next.next;
        // return head;


         //2、双指针
         //设置步频step=n的快慢指针
         ListNode slow=head;
         ListNode fast=head;
         while(n--==0){
             fast=fast.next;
         }
         while(null!=fast){
             fast=fast.next;
             slow=slow.next;
         }
         slow.next=slow.next!=null?slow.next.next:null;
         return head;
     }

     


 }
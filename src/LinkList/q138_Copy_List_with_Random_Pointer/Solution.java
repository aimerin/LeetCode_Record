package LinkList.q138_Copy_List_with_Random_Pointer;

public class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;

        //1、遍历原来链表的每一个结点并拷贝结点放到原来节点的旁边
        Node ptr=head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }



        //2、迭代该新旧节点交替的链表，根据旧节点的random指针更新新节点的random指针
        ptr=head;
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        //3、将next指针正确赋值，将新旧交替链表拆开成新链表和旧链表
        Node ptr_old_list=head;
        Node ptr_new_list = head.next;
        Node head_old=head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list=ptr_new_list.next;
        }
        return head_old;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
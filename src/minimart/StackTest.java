package minimart;

import java.util.Stack;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/04/26/22:20
 */
public class StackTest {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        head.next = listNode2;

        Stack<ListNode> stack = new Stack();
        ListNode tail = new ListNode(-1);
        ListNode back = tail;

        while(head!=null){
            stack.push(head);
            head = head.next;
        }

        while(!stack.empty()){
            ListNode temp = stack.pop();
            temp.next = null;
            back.next = temp;
            back = back.next;
        }

        while (tail != null){
            System.out.println(tail.val);
            tail = tail.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

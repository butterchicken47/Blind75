package LinkedLists;

import com.sun.source.tree.BreakTree;

import java.util.Stack;

public class ReorderList {


    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public static void reorderList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode tempHead = head;
        int len = 0;

        while(tempHead != null){
            stack.push(tempHead);
            tempHead = tempHead.next;
            len++;
        }

        tempHead = head;

        for(int i=0;i<len/2;i++){
            ListNode temp = tempHead.next;
            tempHead.next = stack.pop();
            tempHead.next.next = temp;
            tempHead = temp;
        }
        tempHead.next = null;

    }



}

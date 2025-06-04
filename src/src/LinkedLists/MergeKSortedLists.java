package LinkedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
      private class ListNode {
          int val;
           ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(ln -> ln.val));

        for (ListNode ln : lists) {
            while (ln != null) {
                heap.offer(ln);
                ln = ln.next;
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode curr = heap.poll();
        ListNode dummy = new ListNode(0, curr);
        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next;
        }
        curr.next = null;

        return dummy.next;


    }

}

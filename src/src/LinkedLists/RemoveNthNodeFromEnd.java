package LinkedLists;

public class RemoveNthNodeFromEnd {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode head2 = head;
        ListNode head3 = head2;

        while (head.next !=null){
            size++;
            head = head.next;
        }
        if(size==1)
            return null;

        int startIndex = size - n ;
        int counter = 1;
        if (size == n)
            return head2.next;

        while (head2.next != null){
            if(counter == startIndex){
                if(head2.next.next != null)
                    head2.next = head2.next.next;
                else {
                    head2.next = null;
                    break;
                }
            }
            counter ++;
            head2 = head2.next;
        }
        return head3;

    }

        public ListNode removeNthFromLeetCode(ListNode head, int n) {
            ListNode res = new ListNode(0, head);
            ListNode dummy = res;

            for (int i = 0; i < n; i++) {
                head = head.next;
            }

            while (head != null) {
                head = head.next;
                dummy = dummy.next;
            }

            dummy.next = dummy.next.next;

            return res.next;
        }

}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode hear = newNode;
        ListNode turrtle = newNode;
        while (hear.next != null && hear.next.next != null) {
            turrtle = turrtle.next;
            hear = hear.next.next;
        }

        turrtle.next = turrtle.next.next;
        return head;

    }
}
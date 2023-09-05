class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int size = 0;

        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        if (size == n) {
            return head.next;
        }
        int removeIdx = size - n;
        int i = 1;
        ListNode prev = head;
        while (i < removeIdx) {
            i++;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
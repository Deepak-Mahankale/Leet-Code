class Solution {

    public ListNode FindMiddle(ListNode head) {
        ListNode haer = head;
        ListNode turrtle = head;
        while (haer.next != null && haer.next.next != null) {
            haer = haer.next.next;
            turrtle = turrtle.next;
        }

        return turrtle;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = FindMiddle(head);
        ListNode secondHalf = ReverseList(middle.next);
        ListNode firsthalf = head;
        while (secondHalf != null) {
            if (secondHalf.val != firsthalf.val) {
                return false;
            }
            secondHalf = secondHalf.next;
            firsthalf = firsthalf.next;
        }

        return true;

    }
}
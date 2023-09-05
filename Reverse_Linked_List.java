class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // ListNode prev=head;
        // ListNode curr=head.next;
        // while(curr!=null){
        // ListNode nextNode=curr.next;
        // curr.next=prev;
        // prev=curr;
        // curr=nextNode;
        // }
        // head.next=null;
        // head=prev;
        ListNode n = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return n;
    }
}
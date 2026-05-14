class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Empty list or single node
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length of linked list
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make it circular
        tail.next = head;

        // Reduce unnecessary rotations
        k = k % length;

        // Find new tail position
        int steps = length - k;

        ListNode newTail = tail;

        while (steps > 0) {
            newTail = newTail.next;
            steps--;
        }

        // New head
        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }
}
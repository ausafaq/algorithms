public class FloydTortoiseAndHareAlgorithm {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /*
        Floyd's Tortoise and Hare is a cycle detection algorithm operating on a linked list.
        LeetCode: Linked List Cycle
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

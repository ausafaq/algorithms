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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode intersect = getIntersection(head);
        if(intersect == null) return null;

        ListNode ptr1 = head;
        ListNode ptr2 = intersect;

        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private ListNode getIntersection(ListNode node) {
        ListNode tortoise = node;
        ListNode hare = node;

        while(hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare) {
                return tortoise;
            }
        }
        return null;
    }
}

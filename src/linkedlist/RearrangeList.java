package linkedlist;


class RearrangeList {

    public static void reorder(ListNode head) {
        // TODO: Write your code here
        if(head == null) {
            return;
        }
        ListNode curr = head;
        ListNode firstHalfHead = head;
        ListNode middle = getMiddleNode(curr);
        ListNode middleReverse = reverse(middle);
        ListNode secondHalfHead = middleReverse;
        // rearrange the linked list
        while(firstHalfHead!=null && secondHalfHead!=null) {
            // Modify the pointer of the Linked List 1
            ListNode temp = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            firstHalfHead = temp;

            // Modify the pointer of the second Linked List 2
            temp = secondHalfHead.next;
            secondHalfHead.next = firstHalfHead;
            secondHalfHead = temp;
        }
        // now set the next of last element as null
        if(firstHalfHead!=null) {
            firstHalfHead.next = null;
        }
    }

    private static ListNode reverse(ListNode node) {
        if(node == null) {
            return node;
        }
        ListNode prev = null;
        ListNode curr = node;
        ListNode follow;
        while(curr!=null) {
            follow = curr.next;
            curr.next = prev;
            prev = curr;
            curr = follow;
        }
        return prev;
    }

    private static ListNode getMiddleNode(ListNode curr) {
        if(curr == null) {
            return curr;
        }
        ListNode slow = curr;
        ListNode fast = curr;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
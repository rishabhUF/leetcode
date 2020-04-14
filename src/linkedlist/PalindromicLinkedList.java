package linkedlist;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode curr = head;
        ListNode middle = getMiddleNode(curr);
        ListNode reverseMiddle = reverse(middle);
        ListNode copyReverseMiddle = reverseMiddle;
        boolean result = true;

        while(reverseMiddle!=null) {
            if(curr.value != reverseMiddle.value) {
                result =  false;
                break;
            }

            curr = curr.next;
            reverseMiddle = reverseMiddle.next;
        }

        reverse(copyReverseMiddle);
        return result;
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode follow = curr;

        while(curr!=null) {
            follow = curr.next;
            curr.next = prev;
            prev = curr;
            curr = follow;
        }

        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
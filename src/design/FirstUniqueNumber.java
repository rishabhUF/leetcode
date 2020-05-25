package design;

import java.util.*;

class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
    }
}

class FirstUnique {
    static int[] arr = new int[]{1,2,3,4,5};
    List<Integer> list = new LinkedList<>();
    // list -> C101 2 -> C101 -> D767 -> dE123
    int i;
    // A101 -> 4 bits
    Map<Integer, Node> uniqueMapIndex;
    Node head;
    Node tail;
    Set<Integer> set;

    public FirstUnique(int[] nums) {
        uniqueMapIndex = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        List<Integer> newA = new LinkedList<>();
        head.next = tail;
        tail.prev = head;

        set = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                Node node = addDDL(nums[i]);
                uniqueMapIndex.put(nums[i], node);
            } else {
                if(uniqueMapIndex.containsKey(nums[i])) {
                    //uniqueValues.remove(uniqueMapIndex.get(nums[i]));
                    uniqueMapIndex.remove(nums[i]);
                }
            }
        }
    }

//    public int showFirstUnique() {
//        if(uniqueValues.size() <= 0)
//            return -1;
//        return uniqueValues.get(0);
//    }

    public void add(int value) {
        if(!set.contains(value)) {
            set.add(value);
            //uniqueValues.add(value);
            //uniqueMapIndex.put(value, uniqueValues.size()-1);
        } else {
            if(uniqueMapIndex.containsKey(value)) {
               // uniqueValues.remove(uniqueMapIndex.get(value));
                uniqueMapIndex.remove(value);
            }
        }
    }
    // head ->temp <- tail
    public Node addDDL(int val) {
        Node temp = new Node(val);
        Node curr = head.next;
        Node currTail = tail.prev;
        head.next = temp;
        temp.prev = head;
        temp.next = tail;
        currTail = temp;

        head = head.next;

        return temp;
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
//        System.out.println(firstUnique.showFirstUnique());
//        firstUnique.add(5);
//        System.out.println(firstUnique.showFirstUnique());
//        firstUnique.add(2);
//        System.out.println(firstUnique.showFirstUnique());
//        firstUnique.add(3);
//        System.out.println(firstUnique.showFirstUnique());
    }
}
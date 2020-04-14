package design;

import java.util.Queue;

// Design a thread safe blocking Queue
// This questions gives me opportunity to learn about threads and synchronization.
public class BlockingQueue {

    private Queue<Integer> queue;
    private int capacity;
    private Object mutex;

    public BlockingQueue() {

    }
}

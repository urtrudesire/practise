package Code;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianOrder {

    private final Queue<Integer> queue;

    public MedianOrder() {
        this.queue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        this.queue.add(num);
    }

    public double findMedian() {
        return 0;
    }
}

package Code;

import java.util.Map;
import java.util.TreeMap;

public class MedianFinder {

    private int size;
    private Map<Integer, Integer> map;
    public MedianFinder() {
        this.size = 0;
        this.map = new TreeMap<>();
    }

    public void addNum(int num) {
        this.size = size+1;
        int value = this.map.getOrDefault(num, 0);
        this.map.put(num, value+1);
    }

    public double findMedian() {
        int median = size / 2;
        if (this.size % 2 != 0) {
            median++;
            for (int k : this.map.keySet()) {
                int v = this.map.get(k);
                if (v >= median) {
                    return k;
                }
                median = median - v;
            }
        } else {
            double prev = Integer.MAX_VALUE;
            for (int k : this.map.keySet()) {
                int v = this.map.get(k);
                if (v >= median) {
                    if (median - v == 0 && prev == Integer.MAX_VALUE) {
                        prev = k;
                        median = 1;
                        continue;
                    } else if (prev != Integer.MAX_VALUE) {
                        return ((double) k + prev) / 2;
                    }
                    return k;
                }
                median = median - v;
            }
        }
        return 0;
    }
}

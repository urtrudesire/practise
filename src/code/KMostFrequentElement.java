package code;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class KMostFrequentElement {

    /**
     *
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     */

    public static void main(String[] args) {
        int[] n = {1,1,1,2,2,3};
        int k = 2;
        int[] a = topKFrequent(n, k);
        for(int x : a){
            System.out.println(x);
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        if( k < 1){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for (int num : nums) {
            int val;
            if (map.containsKey(num)) {
                val = map.get(num) + 1;
            } else {
                val = 1;
            }
            map.put(num, val);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(pair -> pair.v, Comparator.reverseOrder()));
        for(int key : map.keySet()){
            queue.add(new Pair(key, map.get(key)));
        }
        while(k > 0){
            ans[k-1] = Objects.requireNonNull(queue.poll()).k;
            k--;
        }
        return ans;
    }

    public static class Pair{
        int k;
        int v;

        Pair(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
}

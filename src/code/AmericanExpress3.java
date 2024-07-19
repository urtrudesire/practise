package code;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AmericanExpress3 {

    /**
     * There are given M threads of different lengths we need to connect these threads into one thread. The cost to connect two threads is equal to sum of their lengths. The task is to connect the threads with minimum cost.
     * <p>
     * Example:
     * Input:
     * 4
     * 4 3 2 6
     * 5
     * 4 2 7 6 9
     * <p>
     * Output:
     * 29
     * 62
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(6);
        list.add(9);
        System.out.println(getMinCost(list));
    }

    public static int getMinCost(List<Integer> threads){
      if(null == threads || threads.size() <= 1){
      	return 0;
      }
      Queue<Integer> q = new PriorityQueue<>();
        q.addAll(threads);
      int cost = 0;
      while(q.size() > 1){
      	int t1 = q.poll();
      	int t2 = q.poll();
      	int sum = t1+t2;
      	cost += sum;
      	q.add(sum);
      }
      return cost;
      }
}

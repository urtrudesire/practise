package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OverlappingIntervals {
    /**
     * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     * Example 2:
     *
     * Input: intervals = [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
     * Example 3:
     *
     * Input: intervals = [[1,2],[2,3]]
     * Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     */

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{1,2},{1,2}};
        OverlappingIntervals o = new OverlappingIntervals();
        System.out.println(o.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] x : intervals){
            List<Integer> list = map.getOrDefault(x[0], new ArrayList<>());
            list.add(x[1]);
            map.put(x[0], list);
        }

        int count = 0;
        for(int v : map.keySet()){
            if(!visited.contains(v)) {
                visited.add(v);
                count += dfs(map.get(v), visited, map);
            }
        }
        return count;
    }

    private int dfs(List<Integer> integers, Set<Integer> visited, Map<Integer, List<Integer>> map) {
        int count = 0;
        for(int x : integers){
            if(visited.contains(x)){
                count++;
            } else {
                visited.add(x);
                if(map.containsKey(x)){
                    count += dfs(map.get(x), visited, map);
                }
            }
        }
        return count;
    }
}

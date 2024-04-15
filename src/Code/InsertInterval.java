package Code;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    /**
     *
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     *
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     *
     * Return intervals after the insertion.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Example 2:
     *
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     */

    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {5,7};
        InsertInterval ob = new InsertInterval();
        System.out.println(ob.insert(intervals, newInterval).length);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        boolean startFound = false;
        int start =0, end=0;
        boolean endFound = false;
        int[][] res = new int[intervals.length+1][2];
        int index = 0;
        for(int[] interval : intervals){
            res[index] = interval;
            index++;
            if(!startFound){
                if(newInterval[0] <= interval[0]){
                    startFound = true;
                    start = newInterval[0];
                }else if(newInterval[0] <= interval[1]){
                    startFound = true;
                    start = interval[0];
                }
                if(!startFound){
                    List<Integer> list = new ArrayList<>();
                    list.add(interval[0]);
                    list.add(interval[1]);
                    result.add(list);
                }
            }
            if(startFound && !endFound){
                if(newInterval[1] < interval[0]){
                    endFound = true;
                    end = newInterval[1];
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    result.add(list);
                    List<Integer> list2 = new ArrayList<>();
                    list2.add(interval[0]);
                    list2.add(interval[1]);
                    result.add(list2);
                }else {
                    if (newInterval[1] == interval[0]) {
                        end = interval[1];
                        endFound = true;
                    } else if (newInterval[1] <= interval[1]) {
                        end = interval[1];
                        endFound = true;
                    }
                    if (endFound) {
                        List<Integer> list = new ArrayList<>();
                        list.add(start);
                        list.add(end);
                        result.add(list);
                    }
                }
                continue;
            }
            if(startFound){
                List<Integer> list = new ArrayList<>();
                list.add(interval[0]);
                list.add(interval[1]);
                result.add(list);
            }
        }
        if(startFound && !endFound){
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(newInterval[1]);
            result.add(list);
        }
        if(!startFound){
            res[index] = newInterval;
            return res;
        }
        int[][] array = new int[result.size()][2];
        index = 0;
        for(List<Integer> z : result){
            int[] temp = new int[2];
            temp[0] = z.get(0);
            temp[1] = z.get(1);
            array[index] = temp;
            index++;
        }
        return array;
    }
}

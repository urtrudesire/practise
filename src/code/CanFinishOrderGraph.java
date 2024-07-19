package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CanFinishOrderGraph {

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
     * Example 2:
     *
     * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
     * Example 3:
     *
     * Input: numCourses = 1, prerequisites = []
     * Output: [0]
     */

    public static void main(String[] args) {
        int n =2;
        int[][] pre = {{0,1}};
        for(int o : findOrder(n, pre)){
            System.out.println(o);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean noLoop = true;
        int[] res = new int[numCourses];
        Set<Integer> ans = new LinkedHashSet<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }

        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            Set<Integer> preConditions = new HashSet<>();
            if(!visited[i]) {
                visited[i] = true;
                preConditions.add(i);
                if (map.containsKey(i)) {
                    if (dfsUtil(map.get(i), visited, preConditions, map, ans)) {
                        noLoop = false;
                        break;
                    }
                }
                preConditions.remove(i);
            }
            ans.add(i);
        }
        if(noLoop){
            int index = 0;
            for(int n : ans){
                res[index] = n;
                index++;
            }
            return res;
        }
        return new int[0];
    }

    private static boolean dfsUtil(List<Integer> conditions, boolean[] visited, Set<Integer> preConditions, Map<Integer, List<Integer>> map, Set<Integer> ans) {
        for (int x : conditions) {
            if (preConditions.contains(x)) {
                return true;
            }
            if (!visited[x]) {
                preConditions.add(x);
                visited[x] = true;
                if (map.containsKey(x)) {
                    if (dfsUtil(map.get(x), visited, preConditions, map, ans))
                        return true;
                }
                preConditions.remove(x);
            }
            ans.add(x);
        }
        return false;
    }
}

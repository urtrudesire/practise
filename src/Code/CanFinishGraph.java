package Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CanFinishGraph {

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     */

    public static void main(String[] args) {
        int[][] pre = {{0,1},{0,2},{1,2}};
        int n = 3;
        System.out.println(canFinish(n, pre));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }

        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            Set<Integer> preConditions = new HashSet<>();
            visited[i] = true;
            preConditions.add(i);
            if(map.containsKey(i)) {
                if (dfsUtil(map.get(i), visited, preConditions, map))
                    return false;
            }
            preConditions.remove(i);
        }
        return true;
    }

    private static boolean dfsUtil(List<Integer> conditions, boolean[] visited, Set<Integer> preConditions, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < conditions.size(); i++) {
            int x = conditions.get(i);
            if(preConditions.contains(x)){
                return true;
            }
            if(visited[x]){
                continue;
            }
            preConditions.add(x);
            visited[x] = true;
            if(map.containsKey(x)) {
                if (dfsUtil(map.get(x), visited, preConditions, map))
                    return true;
            }
            preConditions.remove(x);
        }
        return false;
    }
}

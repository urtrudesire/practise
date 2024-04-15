package Code;

import java.util.HashMap;
import java.util.Map;

public class AmericanExpress2 {
    /**
     * Q2: Given an array A, return the length of the longest zero-one-distance array created using the elements of A. Zero-one-distance array is an array where, the difference between (i+1)th & ith element is either 0 or 1.
     * Eg: A = [2,8,4,5,3,9,12,11]
     * a1 = [2,3,4,5]
     * a2 = [8,9]
     * a3 = [11,12]
     * Ans: 4
     * Constraint: |A| <= 10^5; -10^9 < elements < 10^9
     */

//map - 2  - 4
// 8 - 2
//11 - 2
    public static void main(String[] args) {
        int[] arr = {2,8,4,5,3,9,12,11,2, 5};
        System.out.println(maxArray(arr));
    }
    public static int maxArray(int[] array) {
        if (array.length < 2) {
            return array.length;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : array){
            int value = map.getOrDefault(x, 0);
            map.put(x, value+1);
        }

        for (int k : map.keySet()){
            checkForPrevious(k, map);
            checkForward(k, map);
        }
        for(int n : map.values()){
            if(n > max)
                max = n;
        }
        return max;
    }

    private static void checkForward(int k, Map<Integer, Integer> map) {
        int temp = k;
        int value = map.get(k);
        while (true) {

        }
    }

    private static void checkForPrevious(int k, Map<Integer, Integer> map) {
        int temp = k;
        int value = map.get(k);
        while(true){
            temp--;
            if (map.containsKey(temp)){
                value += map.get(temp);
                map.remove(temp);
            } else {
               break;
            }
        }
        map.put(temp+1, value);
    }
}
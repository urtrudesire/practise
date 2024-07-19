package code;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String[] args) {
        int[] inp = {3,3};
        int[] res = twoSum(inp, 6);
        for(int x : res){
            System.out.println(x);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return result(i, map.get(temp));
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    private static int[] result(int start, int end) {
        return new int[]{start, end};
    }
}

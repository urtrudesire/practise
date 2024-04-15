package Code;

import java.util.LinkedList;
import java.util.Queue;

public class CanJump {
    /**
     *You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     */

    public static void main(String[] args) {
        int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                while(i+1 < nums.length && nums[i+1] == 0) i++;
                q.add(i);
            }
        }
        if(q.isEmpty())
            return true;
        int index = 0;
        int zero = q.poll();
        while(index < zero){
            if(nums[index] + index > zero || nums[index] + index == nums.length-1){
                if(q.isEmpty()){
                    return true;
                }
                while (nums[index]+ index > q.peek()) {
                    q.poll();
                    if(q.isEmpty())
                        return true;
                }
                index = zero + 1;
                zero = q.poll();
            } else {
                index++;
            }
        }
        return false;
    }
}

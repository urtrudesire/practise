package code;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length  < 2){
            return nums.length;
        }
        Arrays.sort(nums);
        int res = 0;
        int seq = 1;
        for (int i = 0; i < nums.length-1; i++){
            int diff = nums[i+1] - nums[i];
            if(diff == 0){
                continue;
            }
            if(diff == 1){
                seq++;
            } else {
                if(res < seq){
                    res = seq;
                }
                seq = 1;
            }
        }
        if(res < seq){
            res = seq;
        }
        return res;
    }
}

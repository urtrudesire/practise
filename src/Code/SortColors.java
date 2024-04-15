package Code;

import java.util.Arrays;

public class SortColors {

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     *
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     *
     * You must solve this problem without using the library's sort function.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     *
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     *
     */

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int z= 0, t = nums.length-1;
        for(int i = 0; i < nums.length && i <=t;){
            int n = nums[i];
            if(n == 0){
                nums[i] = nums[z];
                nums[z] = n;
                z++;
                i++;
            } else if(n == 2){
                nums[i] = nums[t];
                nums[t] = n;
                t--;
            } else {
                i++;
            }
        }
    }
}

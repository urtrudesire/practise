package Code;

public class HouseRob {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
     */

    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length < 3){
            if(nums.length == 0)
                return 0;
            if(nums.length == 1)
                return nums[0];
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length+1];
        int[] dp1 = new int[nums.length+1];
        for(int i = 0 ; i < nums.length+1; i++){
            dp[i] = -1;
            dp1[i] = -1;
        }
        int max1 = Math.max(rob(nums, 0, nums[0], nums.length-1, dp), rob(nums, 1, nums[1], nums.length-1, dp));
        int max2 = Math.max(rob(nums, 1, nums[1], nums.length, dp1), rob(nums, 2, nums[2], nums.length,dp1));
        return Math.max(max1, max2);
    }

    public static int rob(int[] nums, int index, int sum, int length, int[] dp) {
        if(dp[index] != -1){
            return dp[index];
        }
        return dp[index] = sum + Math.max(index+2 <= length-1? rob(nums, index+2, nums[index+2], length, dp): 0, index+3 <= length-1? rob(nums, index+3, nums[index+3], length,dp): 0);
    }
}

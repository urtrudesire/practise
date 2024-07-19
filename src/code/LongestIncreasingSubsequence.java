package code;

public class LongestIncreasingSubsequence {

    /**
     * Given an integer array nums, return the length of the longest strictly increasing
     * subsequence
     * .
     *
     * Example 1:
     *
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * Example 2:
     *
     * Input: nums = [0,1,0,3,2,3]
     * Output: 4
     * Example 3:
     *
     * Input: nums = [7,7,7,7,7,7,7]
     * Output: 1
     */

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
        System.out.println(ob.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(nums.length < 2){
            return nums.length;
        }
        if(nums.length == 2){
            return nums[0] < nums[1] ? 2 : 1;
        }

        int max = 0;
        int[][] dp = new int[length+1][length+1];
        for( int i =0; i < length-1; i++){
            int t = getLengthOfLIS(i, i+1, nums, dp)+1;
            if(max < t){
                max = t;
            }
        }
        return max;
    }

    private int getLengthOfLIS(int prev, int next, int[] nums, int[][] dp) {
        if(next == nums.length){
            return 0;
        }
        if(dp[prev][next] != 0){
            return dp[prev][next];
        }
        if(nums[prev] < nums[next]){
            return dp[prev][next] = Math.max(1 + getLengthOfLIS(next, next+1, nums, dp), getLengthOfLIS(prev, next+1, nums, dp));
        } else {
            return dp[prev][next] = getLengthOfLIS(prev, next+1, nums, dp);
        }
    }
}

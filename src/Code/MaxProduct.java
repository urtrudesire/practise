package Code;

public class MaxProduct {

    /**
     * Given an integer array nums, find a
     * subarray
     *  that has the largest product, and return the product.
     *
     * The test cases are generated so that the answer will fit in a 32-bit integer.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     *
     * Input: nums = [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     *
     */

    public static void main(String[] args) {
        int[] num = {-2, 0, -1};
        System.out.println(maxProduct(num));
    }

    public static int maxProduct(int[] nums) {
        int curMax = 1;
        int curMin = 1;
        int res = Integer.MIN_VALUE;
        for(int x : nums){
            if( x == 0){
                curMax = 1;
                curMin = 1;
            }
            int temp = curMax*x;
            curMax = Math.max(x, Math.max(temp, curMin*x));
            curMin = Math.min(x, Math.min(temp, curMin*x));
            res = Math.max(res, curMax);
        }
        return res;
    }

}

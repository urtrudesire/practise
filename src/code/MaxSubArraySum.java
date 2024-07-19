package code;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] nums = {-5,-4,-1,-7,-8};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int res = 0;
        int maxNeg = Integer.MIN_VALUE;
        int sum = 0;
        boolean pos = false;
        for(int n : nums){
            if(n >= 0){
                sum += n;
                pos = true;
            } else {
                if(n > maxNeg){
                    maxNeg = n;
                }
                if(sum + n < 0){
                    sum = 0;
                }else {
                    sum += n;
                }
            }
            if(sum > res){
                res = sum;
            }
        }
        return pos? res : maxNeg;
    }
}

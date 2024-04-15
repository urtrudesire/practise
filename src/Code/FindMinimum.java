package Code;

public class FindMinimum {

    /**
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     *
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     *
     * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
     *
     * You must write an algorithm that runs in O(log n) time.
     *
     */

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)/2;
        int min = Math.min(nums[start], nums[end]);
        if(nums.length == 2){
            return min;
        }
        while(start < end && mid !=start && mid != end){
            if(nums[start] < nums[mid] && nums[mid] < nums[end]){
                min = Math.min(nums[start], min);
                break;
            } else if(nums[start] > nums[end]){
                if(nums[mid] > nums[start]){
                    start = mid;
                    min = Math.min(min, nums[end]);
                } else {
                    end = mid;
                    min = Math.min(min, nums[start]);
                }
            }
            mid = (start + end)/2;
        }
        min = Math.min(min, Math.min(nums[start], nums[end]));
        return min;
    }
}

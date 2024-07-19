package code;

public class RotatedSearch {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3};
        int target = 8;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target){
        int start = 0, end = nums.length-1, med = (start+end)/2;
        if(nums[start] == target)
            return start;
        if(nums[end] == target)
            return end;
        while (end > start && start != med && end != med){
            if(target == nums[med])
                return med;
            if(target > nums[med]){
                if(target > nums[end] && nums[med] < nums[end]){
                    end = med;
                }else {
                    start = med;
                }
            } else {
                if(target < nums[start] && nums[med] > nums[start]){
                    start = med;
                } else {
                    end = med;
                }
            }
            med = (start + end)/2;
        }
        return -1;
    }
}

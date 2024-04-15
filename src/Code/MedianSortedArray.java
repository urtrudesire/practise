package Code;

import java.util.ArrayList;
import java.util.List;

public class MedianSortedArray {

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        double median;
        int mid = (total/2);

        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        if(i < nums1.length){
            addRemaining(i, nums1, list);
        } else if (j < nums2.length) {
            addRemaining(j, nums2, list);
        }
        if(total%2 == 0) {
            median = (double) (list.get(mid - 1) + list.get(mid)) /2 ;
        } else {
            median = list.get(mid);
        }
        return median;
    }

    private static void addRemaining(int i, int[] nums1, List<Integer> list) {
        while(i < nums1.length){
            list.add(nums1[i]);
            i++;
        }
    }

}

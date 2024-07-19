package code;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * Given an array A[] of N integers and an integer X. The task is to find the sum of three integers in A[] such that it is closest to X.
     *
     *
     * Example 1:
     *
     * Input:
     * N = 4
     * A[] = {-1 , 2, 1, -4}
     * X = 1
     * Output: 2
     * Explaination:
     * Sums of triplets:
     * (-1) + 2 + 1 = 2
     * (-1) + 2 + (-4) = -3
     * 2 + 1 + (-4) = -1
     * 2 is closest to 1.
     *
     * Example 2:
     *
     * Input:
     * N = 5
     * A[] = {1, 2, 3, 4, -5}
     * X = 10
     * Output: 9
     * Explaination:
     * Sums of triplets:
     * 1 + 2 + 3 = 6
     * 2 + 3 + 4 = 9
     * 1 + 3 + 4 = 7
     * ...
     * 9 is closest to 10.
     *
     * Your Task:
     * You don't need to read input or print anything. Your task is to complete the function closest3Sum() which takes the array Arr[] and its size N and X as input parameters and returns the sum which is closest to X.
     *
     * NOTE: If there exists more than one answer then return the maximum sum.
     */

    public static void main(String[] args) {
        int[] a = {-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
        int n = 10;
        int x =-14;
        System.out.println(closest3Sum(a, n, x));
    }

    static int closest3Sum(int[] a, int n, int x)
    {
        // code here
        Arrays.sort(a);
        int sum = a[0]+ a[1] + a[2];
        for(int i = 0; i < n-2; i++){
            int low = i+1;
            int high = n-1;
            while(low < high){
                int tempSum = a[i] + a[low] + a[high];
                if(tempSum == x){
                    return tempSum;
                }
                int tempDiff = Math.abs(x - tempSum);
                if(Math.abs(x-sum) >= tempDiff){
                    sum = tempSum;
                }
                if(tempSum > x){
                    high--;
                } else {
                    low++;
                }
            }
        }
        return sum;
    }
}

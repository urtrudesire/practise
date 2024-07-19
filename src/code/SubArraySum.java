package code;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArraySum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        int index = 0;
        int start = 0;
        int sum = 0;
        boolean found = false;
        while(index < arr.length ){
            sum += arr[index];
            while(sum > s && sum-arr[start] > 0){
                sum -= arr[start];
                start++;
            }
            if (sum == s){
                found = true;
                break;
            }
            index++;
        }
        if(found){
            return new ArrayList<>(Arrays.asList(start+1, index+1));
        }
        else
            return new ArrayList<>(Arrays.asList(-1));
    }
}

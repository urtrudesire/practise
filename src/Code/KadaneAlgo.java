package Code;

public class KadaneAlgo {

    long maxSubarraySum(int arr[], int n){

        // Your code here
        long max = 0, temp = 0;
        boolean flag = true;
        int m = Integer.MIN_VALUE;
        for(int x : arr){
            if( x < 0  && x > m) {
                m = x;
            } else if (x > 0){
                flag = false;
            }
            if(temp + x > 0){
                temp += x;
            } else {
                temp = 0;
            }
            if( max < temp){
                max = temp;
            }
        }
        if(flag){
            return m;
        }
        return max;
    }
}

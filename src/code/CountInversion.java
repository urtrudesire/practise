package code;

public class CountInversion {

    static long inversionCount(long arr[], int n) {
        // Your Code Here
        long ans = 0;
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {10,10,10};
        System.out.println(inversionCount(arr, arr.length));
    }
}

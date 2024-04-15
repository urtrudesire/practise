package Code;

public class SubsetSum {
    public static void main(String[] args) {

        int N = 100;
        int sum = 5142;
        int[] arr = {57,68,27,100,69,49,100,51,71,63,77,20,63,4,11,31,21,23,94,5,56,54,15,88,61,89,5,22,83,55,90,39,74,16,38,42,17,37,93,39,52,69,59,14,24,21,96,96,43,89,100,51,95,15,38,7,55,42,28,37,49,69,75,74,36,12,16,52,1,60,43,52,80,53,65,55,73,12,50,68,100,50,18,94,16,7,100,70,1,79,58,49,47,32,74,35,95,89,38,47};
        Boolean[][] dp = new Boolean[N+1][sum+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < sum+1; j++){
                boolean updated = false;
                if(i == 0){
                    dp[i][j] = false;
                    updated = true;
                }
                if(j == 0){
                    dp[i][j] = true;
                } else if(!updated) {
                    SubsetDp(i, arr, j, dp);
                }
            }
        }
        System.out.println(dp[N][sum]);
        System.out.println("Tell");
    }

    private boolean isSubsetSumRec(int arr[], int sum , int N){
        if(sum == 0){
            return true;
        }
        if(N == 0){
            return false;
        }
        if(arr[N-1] < sum){
            return isSubsetSumRec(arr, sum - arr[N-1], N-1) || isSubsetSumRec(arr, sum, N-1);
        } else {
            return isSubsetSumRec(arr, sum, N-1);
        }
    }

    private static void SubsetDp(int N, int[] arr, int sum, Boolean[][] dp){
        if(arr[N-1] <= sum){
            dp[N][sum] = dp[N-1][sum - arr[N-1]] || dp[N-1][sum];
        } else {
            dp[N][sum] = dp[N-1][sum];
        }
    }


}

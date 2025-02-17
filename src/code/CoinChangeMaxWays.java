package code;

public class CoinChangeMaxWays {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int N = 3,sum = 4;
        System.out.println(count(coins, N, sum));
    }

    public static long count(int[] coins, int N, int sum) {
        // code here.
        long[][] dp = new long[N+1][sum+1];
        for(int i = 0 ; i <=N; i++){
            for(int j = 0; j <=sum; j++){
                if(i == 0 || j == 0){
                    if(j == 0)
                        dp[i][j] = 1;
                    if(i == 0)
                        dp[i][j] = 0 ;
                }else {
                if(coins[i-1] <= j){
                    dp[i][j] = (dp[i][j - coins[i-1]] + dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
                }
            }
        }
        return dp[N][sum];
    }
}

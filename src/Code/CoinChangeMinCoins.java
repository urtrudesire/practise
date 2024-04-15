package Code;

public class CoinChangeMinCoins {

    public static void main(String[] args) {
        int[] coins = {15, 1};
        int M = 2, V = 4;
        System.out.println(minCoins(coins, M, V));
    }

    public static int minCoins(int[] coins, int M, int V) {
        int[][] dp = new int[M+1][V+1];
        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= V; j++){
                if(i == 0 || j == 0){
                    if(j == 0)
                        dp[i][j] = 0;
                    if(i == 0)
                        dp[i][j] = Integer.MAX_VALUE-1;
                }else if(i == 1){
                    dp[i][j] = (j%coins[i-1] == 0)? j/coins[i-1] : Integer.MAX_VALUE-1;
                }else {
                    if (coins[i-1] <= j){
                        dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return (dp[M][V] >= Integer.MAX_VALUE-1)? -1 : dp[M][V];
    }


}

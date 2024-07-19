package code;

public class NumberTransformation {

    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        String num = "781765";
        int min = Integer.MAX_VALUE;
        /*for(int i = 0; i < n; i++) {
            char x = num.charAt(num.length() - 1 - i);
            int temp = getMinCost(num, x, k);
            min = Math.min(temp, min);
        }
        System.out.println(min);
        min = Integer.MAX_VALUE;*/
        for(char t = '0'; t <= '9'; t++) {
            if(!num.contains(String.valueOf(t))){
                continue;
            }
            int[][] dp = new int[n + 1][k + 1];
            getMinCostDp(num, t, k, dp);
            min = Math.min(min, dp[n][k]);
        }
        System.out.println(min);
    }

    private static void getMinCostDp(String num, char x, int k, int[][] dp){
        for(int i = 0 ; i <= num.length(); i++){
            for(int j = 0; j <= Math.min(i, k); j++){
                if(j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                int abs = Math.abs(num.charAt(i-1) - x);
                if(i == j){
                    dp[i][j] = abs + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(abs + dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
    }

    private static int getMinCost(String num, char x, int k){
        if( k == 0)
            return 0;
        char v = num.charAt(num.length()-1);
        if(k == num.length()){
            return Math.abs(v-x) + getMinCost(num.substring(0, num.length()-1), x , k-1);
        } else {
            return Math.min(Math.abs(v-x) + getMinCost(num.substring(0, num.length()-1), x , k-1),
                    getMinCost(num.substring(0, num.length()-1), x , k));
        }
    }
}

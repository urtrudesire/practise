package Code;

public class BooleanParenthesis {

    /**
     * Given a boolean expression with the following symbols.
     *
     * Symbols
     *     'T' ---> true
     *     'F' ---> false
     * And following operators filled between symbols
     *
     * Operators
     *     &   ---> boolean AND
     *     |   ---> boolean OR
     *     ^   ---> boolean XOR
     * Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
     * Let the input be in form of two arrays one contains the symbols (T and F) in order and the other contains operators (&, | and ^}
     */

    public static void main(String[] args) {
        System.out.println(countWays(45, "T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T"));
    }
    static long countWays(int n, String s){
        // code here
        long[][][] dp = new long[n+1][n+1][2];
        for(int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        return solveWays(s, 0, n-1, true, dp);
    }

    private static long solveWays(String s, int i, int j, boolean isTrue, long[][][] dp) {
        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTrue){
                dp[i][j][0] = s.charAt(i) == 'T' ? 1 : 0;
                return dp[i][j][0];
            } else {
                dp[i][j][1] = s.charAt(i) == 'F' ? 1 : 0;
                return dp[i][j][1];
            }
        }
        if(isTrue){
            if(dp[i][j][0] != -1)
                return dp[i][j][0];
        } else {
            if(dp[i][j][1] != -1)
                return dp[i][j][1];
        }

        long ans = 0;
        for(int k = i+1; k < j; k+=2){
            long lt = dp[i][k-1][0] != -1 ? dp[i][k-1][0] : solveWays(s, i, k-1, true, dp);
            long lf = dp[i][k-1][1] != -1 ? dp[i][k-1][1] : solveWays(s, i, k-1, false, dp);
            long rt = dp[k+1][j][0] != -1 ? dp[k+1][j][0] : solveWays(s, k+1, j, true, dp);
            long rf = dp[k+1][j][1] != -1 ? dp[k+1][j][1] : solveWays(s, k+1, j, false, dp);

            char operator = s.charAt(k);
            if(operator == '&'){
                if(isTrue){
                    ans += lt*rt;
                } else {
                    ans += lt*rf + rt*lf + rf*lf;
                }
            } else if(operator == '|'){
                if (isTrue){
                    ans += lt*rf + rt*lf + lt*rt;
                } else {
                    ans += lf*rf;
                }
            } else if(operator == '^'){
                if (isTrue){
                    ans += lf*rt + rf*lt;
                } else {
                    ans += lt*rt + rf*lf;
                }
            }
            if(isTrue){
                dp[i][j][0] = ans;
            } else {
                dp[i][j][1] = ans;
            }
        }
        return ans;
    }
}

package code;

public class ShortestCommonSuperSequence {
    /**
     * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
     * Examples:
     *
     * Input:   str1 = "geek",  str2 = "eke"
     * Output: "geeke"
     */

    public static void main(String[] args) {
        String a = "geek";
        String b = "eke";
        int[][] dp = new int[a.length()+1][b.length()+1];
        int lcs = lcs(a, b, a.length(), b.length(), dp);
        System.out.println(a.length() + b.length() - lcs);
    }

    private static int lcs(String a, String b, int m, int n, int[][] dp){
        for (int i = 0; i <=m; i++){
            for (int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}

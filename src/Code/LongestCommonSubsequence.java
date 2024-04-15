package Code;

public class LongestCommonSubsequence {

    /**
     * Given two strings, find the length of longest subsequence present in both of them. Both the strings are in uppercase latin alphabets.
     *
     * Example 1:
     *
     * Input:
     * A = 6, B = 6
     * str1 = ABCDGH
     * str2 = AEDFHR
     * Output: 3
     * Explanation: LCS for input strings “ABCDGH” and “AEDFHR” is “ADH” of length 3.
     * Example 2:
     *
     * Input:
     * A = 3, B = 2
     * str1 = ABC
     * str2 = AC
     * Output: 2
     * Explanation: LCS of "ABC" and "AC" is "AC" of length 2.
     */

    public static void main(String[] args) {
        String a = "ABC";
        String b = "AC";
        System.out.println(lcsRec(a, b, a.length(), b.length()));
        int[][] dp = new int[a.length()+1][b.length()+1];
        lcsDp(a, b, a.length(), b.length(), dp);
        System.out.println(dp[a.length()][b.length()]);
    }

    private static int lcsRec(String a, String b, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }
        if(a.charAt(m-1) == b.charAt(n-1)){
            return 1 + lcsRec(a, b, m-1, n-1);
        }else {
            return Math.max(lcsRec(a, b, m-1, n), lcsRec(a, b, m, n-1));
        }
    }

    private static void lcsDp(String a, String b, int m, int n, int[][] dp){
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
    }
}

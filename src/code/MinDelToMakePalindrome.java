package code;

public class MinDelToMakePalindrome {

    /**
     * Given a string 'str' of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome. Find the minimum numbers of characters we need to remove.
     * Note: The order of characters should be maintained.
     *
     * Example 1:
     *
     * Input: n = 7, str = "aebcbda"
     * Output: 2
     * Explanation: We'll remove 'e' and
     * 'd' and the string become "abcba".
     * â€‹Example 2:
     *
     * Input: n = 3, str = "aba"
     * Output: 0
     * Explanation: We don't remove any
     * character.
     */

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(minDeletions(s, s.length()));
    }

    static int minDeletions(String str, int n)
    {
        // code here
        String reverse = ReverseString.reverseString(str);
        int[][] dp = new int[n+1][n+1];
        lcs(str, reverse, n, dp);
        return n - dp[n][n];
    }


    private static void lcs(String str, String reverse, int n, int[][] dp) {
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else {
                    if(str.charAt(i-1) == reverse.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
    }
}

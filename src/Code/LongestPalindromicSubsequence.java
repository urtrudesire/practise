package Code;

public class LongestPalindromicSubsequence {
    /**
     * Given a String, find the longest palindromic subsequence.
     *
     * NOTE: Subsequence of a given sequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements
     *
     * Example 1:
     *
     * Input:
     * S = "bbabcbcab"
     * Output: 7
     * Explanation: Subsequence "babcbab" is the
     * longest subsequence which is also a palindrome.
     *
     *
     * Example 2:
     *
     * Input:
     * S = "abcd"
     * Output: 1
     * Explanation: "a", "b", "c" and "d" are
     * palindromic and all have a length 1.
     */

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(longestPalinSubseq(s));
    }

    public static int longestPalinSubseq(String S) {
        //code here
        if(null == S || S.isEmpty()){
            return 0;
        }
        String rev = ReverseString.reverseString(S);
        int[][] dp = new int[S.length()+1][S.length()+1];
        int length = S.length();
        return lcs(S, rev,length, dp);
    }

    private static int lcs(String s, String rev, int length, int[][] dp) {
        for(int i = 0; i < length+1; i++){
            for (int j = 0; j < length+1; j++){
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                } else {
                    if(s.charAt(i-1) == rev.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[length][length];
    }
}

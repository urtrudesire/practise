package Code;

public class LongestCommonSubstring {

    /**
     * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
     * Examples:
     *
     * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
     * Output : 5
     * The longest common substring is “Geeks” and is of length 5.
     */

    public static void main(String[] args) {
        String a = "GeeksforGeeks";
        String b = "GeeksQuiz";
        int[][] dp = new int[a.length()+1][b.length()+1];

        System.out.println(lcsDp(a.toLowerCase(), b.toLowerCase(), a.length(), b.length(), dp));
    }

    private static int lcsDp(String a, String b, int m, int n, int[][] dp){
        int max = 0;
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = 1 +  dp[i-1][j-1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}

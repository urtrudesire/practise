package code;

public class PrintLCS {

    /**
     * Print Longest Common Subsequence
     */

    public static void main(String[] args) {
        String a = "ABCDGH";
        String b = "AEDFHR";
        System.out.println(printLCS(a, b));
    }

    private static String printLCS(String a, String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        lcsDp(a, b, a.length(), b.length(), dp);
        int row = a.length(), column = b.length();
        StringBuilder stringBuilder = new StringBuilder();
        while(row > 0 && column > 0){
            if(a.charAt(row-1) == b.charAt(column-1)){
                stringBuilder.append(a.charAt(row-1));
                row--;
                column--;
            } else {
                if (dp[row-1][column] > dp[row][column-1]) {
                    row--;
                } else {
                    column--;
                }
            }
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
    private static void lcsDp(String a, String b, int m, int n, int[][] dp){
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = 1 +  dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
    }
}

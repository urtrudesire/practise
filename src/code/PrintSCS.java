package code;

public class PrintSCS {

    /**
     * Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest super-sequence exists, print any one of them.
     * Examples:
     *
     *
     * Input: X = "AGGTAB",  Y = "GXTXAYB"
     * Output: "AGXGTXAYB" OR "AGGXTXAYB"
     * OR Any string that represents shortest
     * supersequence of X and Y
     *
     * Input: X = "HELLO",  Y = "GEEK"
     * Output: "GEHEKLLO" OR "GHEEKLLO"
     * OR Any string that represents shortest
     * supersequence of X and Y
     */

    public static void main(String[] args) {
        String a = "HELLO";
        String b = "GEEK";
        System.out.println(printScs(a, b));
    }

    public static String printScs(String a, String b){
        int l1 = a.length();
        int l2 = b.length();
        int[][] dp = new int[l1+1][l2+1];
        lcsDp(a, b, l1, l2, dp);
        StringBuilder stringBuilder = new StringBuilder();
        while (l1 > 0 && l2 > 0){
            if(a.charAt(l1-1) == b.charAt(l2-1)){
                stringBuilder.append(a.charAt(l1-1));
                l2--;
                l1--;
            } else if (dp[l1-1][l2] > dp[l1][l2-1]){
                stringBuilder.append(a.charAt(l1-1));
                l1--;
            } else {
                stringBuilder.append(b.charAt(l2-1));
                l2--;
            }
        }
        if(l1 > 0){
            addRemainingString(a, l1, stringBuilder);
        } else if (l2 > 0){
            addRemainingString(b, l2, stringBuilder);
        }
        return stringBuilder.reverse().toString();
    }

    private static void addRemainingString(String a, int l1, StringBuilder stringBuilder) {
        while(l1 > 0){
            stringBuilder.append(a.charAt(l1-1));
            l1--;
        }
    }

    private static void lcsDp(String a, String b, int m, int n, int[][] dp){
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0){
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

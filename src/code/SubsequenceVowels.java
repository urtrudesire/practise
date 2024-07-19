package code;

import java.util.HashSet;
import java.util.Set;

public class SubsequenceVowels {

    public static void main(String[] args) {
        String x = "trEasu";
        String y = "eauyi";
        System.out.println(lcsv(x.toLowerCase(), y.toLowerCase(), x.length(), y.length()));
    }

    public static int lcsv(String x, String y, int m, int n){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else {
                    if(x.charAt(i-1) == y.charAt(j-1) && vowels.contains(x.charAt(i-1))){
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

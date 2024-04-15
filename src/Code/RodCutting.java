package Code;

public class RodCutting {

    /**
     *
     * Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
     *
     * Note: Consider 1-based indexing.
     *
     * Example 1:
     *
     * Input:
     * N = 8
     * Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
     * Output:
     * 22
     * Explanation:
     * The maximum obtainable value is 22 by
     * cutting in two pieces of lengths 2 and
     * 6, i.e., 5+17=22.
     * Example 2:
     *
     * Input:
     * N=8
     * Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
     * Output:
     * 24
     * Explanation:
     * The maximum obtainable value is
     * 24 by cutting the rod into 8 pieces
     * of length 1, i.e, 8*price[1]= 8*3 = 24.
     * Your Task:
     * You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.
     *
     * Expected Time Complexity: O(N2)
     * Expected Auxiliary Space: O(N)
     */

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(cutRod(price, n));
    }
    public static int cutRod(int[] price, int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++ ){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(i <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
}

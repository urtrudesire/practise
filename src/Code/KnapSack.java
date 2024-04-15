package Code;

public class KnapSack {


    public static void main(String[] args) {

        int[] wt = {30,12,58,32,38,59,6,4,5,8,53,17,4,75,23,41,5,39,31,60,100,60,92,12,37,82,15,47,78,74,6,86,86,35,65,69,87,89,12,97,28,33,100,33,46,47,17,80,60,23,10,49,1,62,7,77,9,49,52,41,82,95,83,79,16,11,16,54,22,96,90,3,7,80,1,56,37,23,85,59,38,45,26,76,4,52,98,75};
        int[] val = {81,28,91,49,65,97,19,75,21,88,47,10,26,67,9,39,27,85,72,64,24,14,87,7,94,100,53,1,83,71,11,87,67,39,73,49,51,44,36,60,57,97,47,2,100,77,77,35,30,42,23,18,43,10,23,52,11,80,44,8,27,90,90,93,40,96,28,60,69,34,40,13,54,74,7,82,81,20,82,5,43,69,24,55,26,49,53,98};
        KnapSack ob = new KnapSack();
        System.out.println(ob.knapSack(71, wt, val, 88));
    }

    int knapSackRec(int W, int[] wt, int[] val, int n) {
        if(W == 0 ||  n == 0)
            return 0;
        if(wt[n-1] > W)
            return knapSackRec(W, wt, val, n-1);
        else
            return Math.max(val[n-1] + knapSackRec(W-wt[n-1], wt, val, n-1),
                    knapSackRec(W, wt, val, n-1));
    }

    int knapSack(int W, int[] wt, int[] val, int n){
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < W+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else{
                    knapSackDp(j, wt, val, i, dp);
                }
            }
        }
        return dp[n][W];
    }

    void knapSackDp(int W, int[] wt, int[] val, int n, int[][] dp){
        if(wt[n-1] > W){
            dp[n][W] = dp[n-1][W];
        }else {
            dp[n][W] = Math.max(dp[n-1][W], val[n-1] + dp[n-1][W - wt[n-1]]);
        }
    }
}

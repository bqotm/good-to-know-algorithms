package knapsack;

public class _01Knapsack {

    public static int maxValue(int[] weight, int[] value, int n, int W) {
        int dp[][] = new int[n+1][W+1];
        for (int item = 0; item<=n; item++) {
            for(int w=0; w<=W; w++) {
                if(item==0 || w==0) {
                    dp[item][w] = 0;
                    continue;
                }
                if(weight[item-1]>w)
                    dp[item][w]=dp[item-1][w];
                if(weight[item-1]<=w)
                    dp[item][w]=Math.max(dp[item-1][w], dp[item-1][w-weight[item-1]]+value[item-1]);
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] weight = {5, 6, 2, 1, 7, 4};
        int[] value = {10, 20, 15, 8, 25, 18};
        System.out.println(maxValue(weight, value, 6, 10));


    }

}

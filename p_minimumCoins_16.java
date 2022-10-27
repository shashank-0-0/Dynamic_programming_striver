public class p_minimumCoins_16 {

    int coins[]={1,2,5,10,20,50,100,500,1000};
    int n=coins.length;
    int[][] dp=new int[n+1][p+1];
        for(int[] row:dp){
        Arrays.fill(row,-1);
    }
        return solve(coins,0,p,n,dp);
    //         TABULATION
    int[][] dp=new int[n+1][p+1];
    for(int i=0;i<p+1;i++){
        dp[n][i]=10000000;
    }

    for(int i=n-1;i>=0;i--){
        for(int j=1;j<p+1;j++){
            if(coins[i]<=j){
                int take=1+dp[i][j-coins[i]];
                int nottake= dp[i+1][j];
                dp[i][j]=Math.min(take,nottake);
            }else{
                dp[i][j]=dp[i+1][j];
            }
        }
    }
    return dp[0][p];

}
    private static int solve(int[] coins,int cur,int maxWeight,int n,int[][] dp){
        if(maxWeight==0){
            return 0;
        }
        if(cur==n){
            return 1000000;
        }
        if(dp[cur][maxWeight]!=-1){
            return dp[cur][maxWeight];
        }
        if(coins[cur]<=maxWeight){
            int take=1+solve(coins,cur,maxWeight-coins[cur],n,dp);
            int nottake= solve(coins,cur+1,maxWeight,n,dp);
            return dp[cur][maxWeight]=Math.min(take,nottake);
        }else{
            return dp[cur][maxWeight]=solve(coins,cur+1,maxWeight,n,dp);
        }
    }
}
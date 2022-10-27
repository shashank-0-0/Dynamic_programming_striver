public class s_unboundedKnapsack_19 {'

    static int knapsack(int[] weight, int[] value, int n, int maxWeight){

    int[][] dp=new int[n+1][maxWeight+1];
        for(int[] row:dp){
        Arrays.fill(row,-1);
    }
        return solve(weight,value,0,maxWeight,n,dp);

        //Tabulation
        int[][] dp=new int[n+1][maxWeight+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=maxWeight;j++){
                if(weight[i]<=j){
                    int take=value[i]+dp[i][j-weight[i]];
                    int nottake= dp[i+1][j];
                    dp[i][j]=Math.max(take,nottake);
                }else{
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        return dp[0][maxWeight];

}
    private static int solve(int[] weight,int[] value,int cur,int maxWeight,int n,int[][] dp){
        if(cur==n || maxWeight==0){
            return 0;
        }
        if(dp[cur][maxWeight]!=-1){
            return dp[cur][maxWeight];
        }
        if(weight[cur]<=maxWeight){
            int take=value[cur]+solve(weight,value,cur,maxWeight-weight[cur],n,dp);
            int nottake= solve(weight,value,cur+1,maxWeight,n,dp);
            return dp[cur][maxWeight]=Math.max(take,nottake);
        }else{
            return dp[cur][maxWeight]=solve(weight,value,cur+1,maxWeight,n,dp);
        }

    }
    //Rod cutting problem is the exact problem with different definition check out
}
public class r_coinchange2_18 {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,n,coins,amount,dp);

        // TABULATION
        int k=amount;
        int[][] dp =new int[n+1][k+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=k;j++){
                if(coins[i]<=j){
                    dp[i][j]=dp[i][j-coins[i]] + dp[i+1][j];
                }else{
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        //initial recursion call
        return dp[0][k];



    }
    private static int  solve(int cur_ind,int n,int[] arr,int k,int[][] dp){

        if(k==0){
            return 1;
        }
        if(cur_ind==n){
            return 0;
        }
        if(dp[cur_ind][k]!=-1){
            return dp[cur_ind][k];
        }
        if(arr[cur_ind]<=k){
            return  dp[cur_ind][k]=solve(cur_ind,n,arr,k-arr[cur_ind],dp)+solve(cur_ind+1,n,arr,k,dp);
        }else{
            return  dp[cur_ind][k]=solve(cur_ind+1,n,arr,k,dp);
        }
    }
}
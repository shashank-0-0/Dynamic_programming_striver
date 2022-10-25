public class k_subsetsumk_11 {

      return solve(0,n,arr,k);

      //TABULATION (represented 'cur_ind' states by i anf 'k' states as j)
      boolean[][] dp =new boolean[n+1][k+1];
      for(int i=0;i<n+1;i++){
          dp[i][0]=true;
      }
      for(int i=n-1;i>=0;i--){
          for(int j=k;j>=0;j--){
              if(arr[i]<=j){
                  dp[i][j]=dp[i+1][j-arr[i]] || dp[i+1][j];
              }else{
                  dp[i][j]=dp[i+1][j];
              }
          }
      }
      //initial recursion call
      return dp[0][k];

}
    private static boolean solve(int cur_ind,int n,int[] arr,int k){

        if(k==0){
            return true;
        }
        if(cur_ind==n){
            return false;
        }
        
        if(arr[cur_ind]<=k){
            return solve(cur_ind+1,n,arr,k-arr[cur_ind],dp) || solve(cur_ind+1,n,arr,k,dp);
        }else{
            return solve(cur_ind+1,n,arr,k,dp);
        }
    }
}

public class zj_LIS {
    public int lengthOfLIS(int[] nums) {
        
         int n=nums.length;
         int[][] dp=new int [n+1][n+1];
         for(int[] row:dp){
             Arrays.fill(row,-1);
         }
         return solve(0,-1,nums,dp);

        //TABULATION
      
      int n=nums.length;
        int[][] dp=new int[n+1][n+1];   
        for(int cur_ind=n-1;cur_ind>=0;cur_ind--){
            for(int prev_ind=cur_ind;prev_ind>=0;prev_ind--){
                int not_pick=dp[cur_ind+1][prev_ind];
                int pick=0;
                if(prev_ind==0 || nums[cur_ind]>nums[prev_ind-1]){
                    pick= 1+dp[cur_ind+1][cur_ind+1];
                }
                dp[cur_ind][prev_ind]=Math.max(pick,not_pick);
            }
        }
         return dp[0][0];

    }
    private static int solve(int cur_ind,int prev_ind,int nums[],int[][] dp){
        if(cur_ind>=nums.length){
            return 0;
        }
        if(dp[cur_ind][prev_ind+1]!=-1){
            return dp[cur_ind][prev_ind+1];
        }
        int not_pick=solve(cur_ind+1,prev_ind,nums,dp);
        int pick=0;
        if(prev_ind==-1 || nums[cur_ind]>nums[prev_ind]){
            pick= 1+solve(cur_ind+1,cur_ind,nums,dp);
        }

        return dp[cur_ind][prev_ind+1]=Math.max(pick,not_pick);

    }
 

    
   //we will define dp[n] , where  dp[i] signify longest lis that ends at index i
   int n=nums.length;
   int dp[]=new int[n];
   Arrays.fill(dp,1);
   for(int i=0;i<n;i++){
       for(int j=i-1;j>=0;j--){
           if(nums[j]<nums[i]){
               dp[i]=Math.max(dp[i],1+dp[j]);
           }
       }
   }
   int ans=1;
   for(int i:dp){
       ans=Math.max(ans,i);
   }
   return ans;



}
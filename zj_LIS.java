public class zj_LIS {
    public int lengthOfLIS(int[] nums) {

         int n=nums.length;
         int[][] dp=new int[n+1][n+1];
         for(int[] row:dp){
             Arrays.fill(row,-1);
         }
         return solve(0,-1,nums,dp);

        //TABULATION
        //can prevind be n-1 for every element nope it can be from curind-1 to -1;
        // and here while picling and not picking you have to do the coordinate change

        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int cur_ind=n-1;cur_ind>=0;cur_ind--){
            for(int prev_ind=cur_ind-1;prev_ind>=-1;prev_ind--){
                int not_pick=dp[cur_ind+1][prev_ind+1];
                int pick=0;
                if(prev_ind==-1 || nums[cur_ind]>nums[prev_ind]){
                    pick= 1+dp[cur_ind+1][cur_ind+1];
                }
                dp[cur_ind][prev_ind+1]=Math.max(pick,not_pick);
            }
        }
        return dp[0][-1+1];

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
    //NEETCODE's SOLUTION

    [1,2,4,3] LIS[3]=1 , LIS[2]=Math.max(1,1+LIS[3]) 1+LIS[3] only if nums[2]<nums[3] ,
    LIS[1] = nums[1]<nums[2] and nums[1]<nums[3] =Math.max(1,1+LIS[2],1+LIS[3]);
    LIS[0]=nums[0]<nums[1],nums[2],num[3] = Math.ma(1,1+LIS[1],1+LIS[2],1+LIS[3]);

    int n=nums.length;
    int ans=0;
    int[] LIS=new int[n];
    Arrays.fill(LIS,1);

    for(int i=n-1;i>=0;i--){
        for(int j=i+1;j<n;j++){
            if(nums[i]<nums[j]){
                LIS[i]=Math.max(LIS[i],1+LIS[j]);
            }
        }
    }
    for(int i:LIS){
        ans=Math.max(ans,i);
    }
    return ans;

    // LIS[i] represents the longest increasing subsequence starting from i to n i.e; with i starting



}
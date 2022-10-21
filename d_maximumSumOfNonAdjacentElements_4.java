import java.util.Arrays;

public class d_maximumSumOfNonAdjacentElements_4 {
    public int rob(int[] nums) {

        int[] dp=new int[nums.length+2];
         Arrays.fill(dp,-1);
         return hr(nums,0,dp);

        //TABULATION
        dp[nums.length]=0;
        dp[nums.length+1]=0;
        for(int i=nums.length-1;i>=0;i--){
            int rob=nums[i]+dp[i+2];
            int no_rob=dp[i+1];
            dp[i]=Math.max(rob,no_rob);
        }
        return dp[0];

    }
    private static int hr(int nums[],int cur_ind,int dp[]){
        if(cur_ind>=nums.length){
            return 0;
        }
        if(dp[cur_ind]!=-1){
            return dp[cur_ind];
        }

        int rob=nums[cur_ind]+hr(nums,cur_ind+2,dp);
        int no_rob=hr(nums,cur_ind+1,dp);
        return dp[cur_ind]=Math.max(rob,no_rob);

    }
}

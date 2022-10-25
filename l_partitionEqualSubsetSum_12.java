public class l_partitionEqualSubsetSum_12 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2==1){
            return false;
        }else{
            return subsetsum(nums,sum/2);
        }

    }
    static boolean subsetsum(int[] arr,int k) {
        int n=arr.length;
        boolean[][] dp =new boolean[n+1][k+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=n-1;i>=0;i--)\{
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
}
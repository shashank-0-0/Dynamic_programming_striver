public class m_partitionMinimumSubsetSum_13 {
    public int solve(int arr[]){
        int n=arr.length;
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        boolean[][] dp=new boolean[n+1][sum+1];
        subsetsum(arr,sum,dp);
        //our first row will tell us all the subset sums that can be made;
        int ans=sum;
        for(int i=0;i<sum+1;i++){
            if(dp[0][i]){
                int s1=i;
                int s2=sum-s1;
                ans=Math.min(ans,Math.abs(s2-s1));
            }
        }
        return ans;
    }




    static void subsetsum(int[] arr,int k,boolean[][] dp) {
        int n=arr.length;

        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=n-1;i>=0;i--) {
            for (int j = k; j >= 0; j--) {
                if (arr[i] <= j) {
                    dp[i][j] = dp[i + 1][j - arr[i]] || dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }


    }
}
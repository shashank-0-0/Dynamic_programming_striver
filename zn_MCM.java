public class zn_MCM {
    public static int matrixMultiplication(int[] arr , int N) {
        // Write your code here
//         int dp[][]=new int[N][N];
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
//         return solve(1,N-1,arr,dp);

        //not understood yet
        int dp[][]=new int[N][N];
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                if(i==j){
                    continue;
                }
                int ans=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int temp=dp[i][k]+dp[k+1][j]+(arr[i-1]*arr[k]*arr[j]);
                    if(temp<ans){
                        ans=temp;
                    }
                }
                dp[i][j]=ans;
            }
        }
        return dp[1][N-1];

    }
    private static int solve(int i,int j,int[] arr,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solve(i,k,arr,dp)+solve(k+1,j,arr,dp)+(arr[i-1]*arr[k]*arr[j]);
            if(temp<ans){
                ans=temp;
            }
        }
        return dp[i][j]=ans;

    }
}
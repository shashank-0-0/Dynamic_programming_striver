public class f_unique_paths {

    public int uniquePaths(int m, int n) {

         int[][] dp=new int[m+1][n+1];
         for(int[] row:dp){
         Arrays.fill(row,-1);
         }
         return paths(0,0,m,n,dp);

        //TABULATION (understand tabulation)

        int[][] dp=new int[m+1][n+1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i][j+1]+dp[i+1][j];
                }
            }
        }
        return dp[0][0];

        int[][] dp=new int[m+1][n+1];
        dp[m-1][n]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j]=dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];
    }
    private static int paths(int cur_row,int cur_col,int m,int n,int[][] dp){
        if(cur_row==m-1 && cur_col==n-1){
            return 1;
        }
        if(cur_row>=m || cur_col>=n){
            return 0;
        }
        if(dp[cur_row][cur_col]!=-1){
            return dp[cur_row][cur_col];
        }
        int right=paths(cur_row,cur_col+1,m,n,dp);
        int down=paths(cur_row+1,cur_col,m,n,dp);

        return dp[cur_row][cur_col]=right+down;
    }

}

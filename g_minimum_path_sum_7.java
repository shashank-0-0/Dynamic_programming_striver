public class g_minimum_path_sum_7 {
    public int minPathSum(int[][] grid) {
        int m=grid.length;int n=grid[0].length;
         int[][] dp=new int[m+1][n+1];
         for(int[] row:dp){
             Arrays.fill(row,-1);
         }
         return f(0,0,grid,dp);


        // TABULATION
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][n]=Integer.MAX_VALUE;
        }
        for(int j=0;j<n+1;j++){
            dp[m][j]=Integer.MAX_VALUE;
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=grid[i][j];
                }else{
                    dp[i][j]=grid[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[0][0];

    }
    static int f(int cur_row,int cur_col,int grid[][],int dp[][]){
        if(cur_row==grid.length-1 && cur_col==grid[cur_row].length-1){
            return grid[cur_row][cur_col];
        }
        if(cur_row>=grid.length || cur_col>=grid[cur_row].length){
            return Integer.MAX_VALUE;
        }
        if(dp[cur_row][cur_col]!=-1){
            return dp[cur_row][cur_col];
        }
        int right=f(cur_row,cur_col+1,grid,dp);
        int down=f(cur_row+1,cur_col,grid,dp);
        return dp[cur_row][cur_col]=grid[cur_row][cur_col]+Math.min(right,down);
    }
}

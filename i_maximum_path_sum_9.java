public class i_maximum_path_sum_9 {
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int ans=Integer.MIN_VALUE;
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<matrix[0].length;i++){

            ans=Math.max(ans,f(0,i,matrix,dp));
        }
        return ans;

        //TABULATION
        for(int[] row:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        for(int i=0;i<matrix[0].length;i++){
            dp[matrix.length-1][i]=matrix[matrix.length-1][i];
        }
        int m=matrix.length;int n=matrix[0].length;
        for(int j=m-2;j>=0;j--) {
            for(int k=n-1;k>=0;k--) {
                int down=dp[j+1][k];
                int down_right=dp[j+1][k+1];
                int down_left=Integer.MIN_VALUE;
                if(k>0) {
                    down_left=dp[j+1][k-1];
                }

                dp[j][k]=matrix[j][k]+Math.max(down,Math.max(down_left,down_right));
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            ans=Math.max(ans,dp[0][i]);
        }
        return ans;

    }
    static int f(int cur_row,int cur_col,int grid[][],int dp[][]){

        if(cur_row>=grid.length || cur_col>=grid[cur_row].length
                || cur_col<0
        ){
            return Integer.MIN_VALUE;
        }
        if(cur_row==grid.length-1){
            return grid[cur_row][cur_col];
        }

        if(dp[cur_row][cur_col]!=-1){
            return dp[cur_row][cur_col];
        }
        int down=f(cur_row+1,cur_col,grid,dp);
        int down_left=f(cur_row+1,cur_col-1,grid,dp);
        int down_right=f(cur_row+1,cur_col+1,grid,dp);
        return dp[cur_row][cur_col]=grid[cur_row][cur_col]+
                Math.max(down,Math.max(down_left,down_right));
    }

}
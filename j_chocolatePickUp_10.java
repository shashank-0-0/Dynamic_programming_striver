public class j_chocolatePickUp_10{
 int[][][] dp=new int[r+1][c+1][c+1];
        for(int[][] mat:dp){
            for(int[] row:mat){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,0,c-1,r,c,grid,dp);
	}
    private static int solve(int currow,int curcol_1,int curcol_2,int r,int c,int[][] grid
                            ,int[][][] dp){
        if(curcol_1<0 || curcol_1>=c || curcol_2<0
           || curcol_2>=c){
            return 0;
        }

        if(currow==r-1){
            if(curcol_1==curcol_2){
                return grid[currow][curcol_1];
            }
            return grid[currow][curcol_1]+
                   grid[currow][curcol_2];
        }
        if(dp[currow][curcol_1][curcol_2]!=-1){
            return dp[currow][curcol_1][curcol_2];
        }
        int max=0;
        for(int alice=-1;alice<=1;alice++){
            for(int bob=-1;bob<=1;bob++){
                if(curcol_1==curcol_2){
                    max=Math.max(max,
                        solve(currow+1,curcol_1+alice,curcol_2+bob,r,c,grid,dp)+grid[currow][curcol_1]);
                }else{
                    max=Math.max(max,solve(currow+1,curcol_1+alice,curcol_2+bob,r,c,grid,dp)
                                 +grid[currow][curcol_1]+grid[currow][curcol_2]);
                }
            }
        }
        return dp[currow][curcol_1][curcol_2]=max;
    }
}
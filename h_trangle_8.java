
public class h_trangle_8 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()+1][triangle.size()+1];
         for(int[] row:dp){
             Arrays.fill(row,-1);
         }
         return f(0,0,triangle,dp);


        //TABULATION
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int m=triangle.size();
        for(int j=0;j<m;j++){
            dp[m-1][j]=triangle.get(m-1).get(j);
        }

        for(int i=m-2;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(j<triangle.get(i).size()){
                    dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                }
            }
        }

        return dp[0][0];


    }
    static int f(int i,int j,List<List<Integer>> triangle,int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int d=f(i+1,j,triangle,dp);
        int dg=f(i+1,j+1,triangle,dp);
        return dp[i][j]=Math.min(d,dg)+triangle.get(i).get(j);
    }


}
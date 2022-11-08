public class Min_cost_to_cut_stick{
    public int minCost(int n, int[] cuts) {
        int[] cuts2=new int[cuts.length+2];
        cuts2[0]=0;cuts2[1]=n;
        for(int i=2;i<cuts2.length;i++){
            cuts2[i]=cuts[i-2];
        }
        Arrays.sort(cuts2);
        int[][] dp=new int[cuts.length+1][cuts.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(1,cuts.length,cuts2,dp);
    }

    private static int solve(int i,int j,int[] cuts2,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int temp=cuts2[j+1]-cuts2[i-1]+solve(i,k-1,cuts2,dp)+solve(k+1,j,cuts2,dp);
            if(temp<ans){
                ans=temp;
            }
        }
        return dp[i][j]=ans;
    }
}
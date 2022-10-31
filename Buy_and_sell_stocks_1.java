public class Buy_and_sell_stocks_1 {
    public int maxProfit(int[] prices) {

         int n=prices.length;
         int[][][] dp=new int[n+1][2][2];
         for(int[][] mat:dp){
         for(int[] row:mat){
             Arrays.fill(row,-1);
         }
         }
         return besttime(0,1,1,prices,dp);

        //TABULATION
        int n=prices.length;
        int[][][] dp=new int[n+1][2][2];
        //no need of base case since its already 0

        for(int cur=n-1;cur>=0;cur--){
            for(int canbuy=0;canbuy<=1;canbuy++){
                for(int trans=1;trans<=1;trans++){
                    int Idle= dp[cur+1][canbuy][trans];
                    if(canbuy==1){
                        int buy = -prices[cur]+dp[cur+1][0][trans];
                        dp[cur][canbuy][trans]=Math.max(Idle,buy);
                    }else{
                        int sell=prices[cur]+dp[cur+1][1][trans-1];
                        dp[cur][canbuy][trans]=Math.max(Idle,sell);
                    }
                }
            }
        }
        return dp[0][1][1];
    }
    //CANBUY =1 , CANNOT BUY =0
    private static int besttime(int cur,int canbuy,int trans,int[] prices,int[][][] dp){

        if(cur>=prices.length || trans<=0){
            return 0;
        }
        if(dp[cur][canbuy][trans]!=-1){
            return dp[cur][canbuy][trans];
        }
        int Idle= besttime(cur+1,canbuy,trans,prices,dp);
        if(canbuy==1){
            int buy = -prices[cur]+besttime(cur+1,0,trans,prices,dp);
            return dp[cur][canbuy][trans]=Math.max(Idle,buy);
        }else{
            int sell=prices[cur]+besttime(cur+1,1,trans-1,prices,dp);
            return dp[cur][canbuy][trans]=Math.max(Idle,sell);
        }
    }
}
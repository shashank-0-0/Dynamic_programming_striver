public class zi_Buy_and_sell_stocks_withTransactionFees {
    public int maxProfit(int[] prices, int fee) {
         int n=prices.length;
         int[][] dp=new int[n+1][2];
         for(int[] row:dp){
             Arrays.fill(row,-1);
         }
         return besttime(0,1,prices,dp,fee);

        //TABULATION
        int n=prices.length;
        int[][] dp=new int[n+2][2];
        // base case no need cuz 0 by default

        for(int cur=n-1;cur>=0;cur--){
            for(int canbuy=0;canbuy<=1;canbuy++){
                int Idle= dp[cur+1][canbuy];
                if(canbuy==1){
                    int buy = -prices[cur]+dp[cur+1][0];
                    dp[cur][canbuy]=Math.max(Idle,buy);
                }else{
                    int sell=prices[cur]+dp[cur+1][1]-fee;
                    dp[cur][canbuy]=Math.max(Idle,sell);
                }
            }
        }
        return dp[0][1];

    }
    private static int besttime(int cur,int canbuy,int[] prices,int[][] dp,int fee){

        if(cur>=prices.length){
            return 0;
        }
        if(dp[cur][canbuy]!=-1){
            return dp[cur][canbuy];
        }

        int Idle= besttime(cur+1,canbuy,prices,dp,fee);
        if(canbuy==1){

            int buy = -prices[cur]+besttime(cur+1,0,prices,dp,fee);
            return dp[cur][canbuy]=Math.max(Idle,buy);

        }else{

            int sell=prices[cur]+besttime(cur+1,1,prices,dp,fee)-fee;
            return dp[cur][canbuy]=Math.max(Idle,sell);

        }

    }


}
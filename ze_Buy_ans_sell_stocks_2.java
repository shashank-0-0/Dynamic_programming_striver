public class ze_Buy_ans_sell_stocks_2 {
    public int maxProfit(int[] prices) {

        int n=prices.length;
         int[][] dp=new int[n+1][2];
         for(int[] row:dp){
             Arrays.fill(row,-1);
         }
//        BUY = 1 , cant buy = 0;
         return besttime(0,1,1,prices,dp);

        int[][] dp=new int[n+1][2];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int Idle=dp[i+1][j];
                if(j==1){
                    int buy = -prices[i]+dp[i+1][0];
                    dp[i][j]=Math.max(Idle,buy);
                }else{
                    int sell=prices[i]+dp[i+1][1];
                    dp[i][j]=Math.max(Idle,sell);
                }
            }
        }
        return dp[0][1];
    }
    private static int besttime(int cur,int canbuy,int trans,int[] prices,int[][] dp){


        if(cur>=prices.length ){
            return 0;
        }
        if(dp[cur][canbuy]!=-1){
            return dp[cur][canbuy];
        }
        int Idle= besttime(cur+1,canbuy,trans,prices,dp);
        if(canbuy==1){
            int buy = -prices[cur]+besttime(cur+1,0,trans,prices,dp);
            return dp[cur][canbuy]=Math.max(Idle,buy);
        }else{

            int sell=prices[cur]+besttime(cur+1,1,trans-1,prices,dp);
            return dp[cur][canbuy]=Math.max(Idle,sell);

        }


    }


}
import java.util.Arrays;

public class b_Climbing_Stairs_2 {
    public int climbStairs(int n) {

        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return cs(n,dp);

        //Tabulation
//        dp[0]=1;
//        dp[1]=1;
//        for(int i=2;i<n+1;i++){
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n];



    }
    static int cs(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a= cs(n-1,dp);
        int b=cs(n-2,dp);
        return dp[n]=a+b;
    }
}

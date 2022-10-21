import java.util.Arrays;

public class Fibonacci_1 {

    public int fib(int n) {

         int[] dp=new int[n+1];
         Arrays.fill(dp,-1);
         return fibb(n,dp);

        //tabulation
//        if(n==0){return 0;}
//        dp[0]=0;dp[1]=1;
//        for(int i=2;i<=n;i++){
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n];

    }
    private static int fibb(int n,int[] dp){
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n<=1){
            return n;
        }
        return dp[n]=fibb(n-1,dp)+fibb(n-2,dp);
    }

}

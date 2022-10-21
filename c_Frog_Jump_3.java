import java.util.Arrays;

public class c_Frog_Jump_3 {

    public static int frogJump(int n, int heights[]) {

        int []dp=new int[n];
        Arrays.fill(dp,-1);
        return fg(n-1,heights,dp);
        //Tabulation
//         dp[0]=0;
//         for(int i=1;i<n;i++){
//             int onestep=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
//             int twostep=Integer.MAX_VALUE-1;
//             if(i>1){
//                 twostep=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
//             }
//             dp[i]=Math.min(onestep,twostep);
//         }
//         return dp[n-1];

    }
    private static int fg(int n,int heights[],int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int onestep=fg(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]);
        int twostep=Integer.MAX_VALUE-1;
        if(n>1){
            twostep=fg(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);
        }
        return dp[n]=Math.min(onestep,twostep);
    }
    //another way
    private static int fg_2(int n,int heights[],int[] dp){
        if(n==0){
            return 0;
        }
        if(n==1){
            return Math.abs(heights[1]-heights[0]);
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int onestep=fg_2(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]);
        int twostep=fg_2(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);

        return dp[n]=Math.min(onestep,twostep);
    }

}

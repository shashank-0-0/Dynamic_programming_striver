import java.util.Arrays;

public class e_Ninjas_training_5 {
    public static int ninjaTraining(int n, int points[][]){
        int[][] dp=new int[n+1][4];
        for(int[] row:dp){
        Arrays.fill(row,-1);
        }
        return solve(0,points,3,dp);

        //TABULATION
        for(int day=n-1;day>=0;day--){
            for(int last=0;last<=3;last++){
                int ans=Integer.MIN_VALUE;
                for(int j=0;j<3;j++){
                    if(j==last){
                        continue;
                    }
                    int min=points[day][j]+dp[day+1][j];
                    ans=Math.max(min,ans);
                }
                dp[day][last]=ans;
            }
        }
        //initial call that u made to recursion
        return dp[0][3];

}
    private static int solve(int cur_day,int[][] points,int last,int[][] dp){

        if(cur_day==points.length-1){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i==last){
                    continue;
                }
                max=Math.max(max,points[cur_day][i]);
            }
            return max;
        }
        if(dp[cur_day][last]!=-1){
            return dp[cur_day][last];
        }
        int ans=Integer.MIN_VALUE;
        for(int j=0;j<3;j++){
            if(j==last){
                continue;
            }
            int min=points[cur_day][j]+solve(cur_day+1,points,j,dp);

            ans=Math.max(min,ans);
        }
        return dp[cur_day][last]=ans;
//
    }


}

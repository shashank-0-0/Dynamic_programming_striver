public class za_distinctSubsequence_27 {
    public int numDistinct(String s, String t) {
        int m=s.length();int n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }


        return distinctSubsequence(m,n,s,t,dp);

        //TABULATION
        for(int i=0;i<m+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+ dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[m][n];

    }
    private static int distinctSubsequence(int m,int n,String s,String t,int[][] dp){
        if(n==0){
            return 1;
        }
        if(m==0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s.charAt(m-1)==t.charAt(n-1)){
            return dp[m][n]=distinctSubsequence(m-1,n-1,s,t,dp) + distinctSubsequence(m-1,n,s,t,dp);
        }else{
            return dp[m][n]=distinctSubsequence(m-1,n,s,t,dp);
        }
    }
}
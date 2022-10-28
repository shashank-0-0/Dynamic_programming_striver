public class y_minInsertDeleteToConvertAtoB_25 {
    public int minInsetDelete(String A, String B) {
        int m=A.length();
        int n=B.length();
        int dp[][]=new int[m+1][n+1];

        //TABULATION
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return (A.length()-dp[m][n])+(B.length()-dp[m][n]);

    }
}
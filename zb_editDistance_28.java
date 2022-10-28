public class zb_editDistance_28 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return edit_Distance(m,n,word1,word2,dp);

        //TABULATION

        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<n+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int insert=1+dp[i][j-1];
                    int delete=1+dp[i-1][j];
                    int replace=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(insert,Math.min(delete,replace));
                }
            }
        }
        return dp[m][n];


    }
    private static int edit_Distance(int m,int n,String word1,String word2,int[][] dp){
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(word1.charAt(m-1)==word2.charAt(n-1)){
            return dp[m][n]=edit_Distance(m-1,n-1,word1,word2,dp);
        }else{
            int insert=1+edit_Distance(m,n-1,word1,word2,dp);
            int delete=1+edit_Distance(m-1,n,word1,word2,dp);
            int replace=1+edit_Distance(m-1,n-1,word1,word2,dp);
            return dp[m][n]=Math.min(insert,Math.min(delete,replace));
        }


    }
}
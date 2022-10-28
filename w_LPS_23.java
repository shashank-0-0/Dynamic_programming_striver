public class w_LPS_23 {
    public int longestPalindromeSubseq(String s) {
        StringBuilder input1 = new StringBuilder();
        input1.append(s);
        String text2=input1.reverse().toString();
        int dp[][]=new int[s.length()+1][text2.length()+1];

        int m=s.length();
        int n=text2.length();
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[m][n];
    }
}
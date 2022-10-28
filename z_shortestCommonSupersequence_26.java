public class z_shortestCommonSupersequence_26 {
    //scs length
    public static int shortestSupersequence(String A, String B) {
        // Write your code here..
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
            return A.length()+B.length()-dp[m][n];
    }
    //print scs
    public static String shortestSupersequence(String text1, String text2) {
        // Write your code here..
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];

        //TABULATION
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        int i=m;int j=n;
        String scs="";
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                scs+=text1.charAt(i-1);
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    scs+=text2.charAt(j-1);
                    j--;
                }else{
                    scs+=text1.charAt(i-1);
                    i--;
                }
            }
        }
        while(i>0) {
            scs+=text1.charAt(i-1);
            i--;

        }
        while(j>0) {
            scs+=text2.charAt(j-1);
            j--;

        }
        StringBuilder sb=new StringBuilder(scs);
        sb.reverse();
        return sb.toString();

    }
}
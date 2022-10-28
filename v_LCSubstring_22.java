public class v_LCSubstring_22 {
    // Again understand how the dp table (tabulation0 works in lcs
    public int printlcs(String text1,String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        int ans=0;

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
                    ans=Math.max(ans,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }

            }
        }
        return ans;

    }
}
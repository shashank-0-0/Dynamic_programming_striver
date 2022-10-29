public class zc_wildCardMatching_29 {
    public boolean isMatch(String s, String p) {
        int m=s.length();int n=p.length();

        return wildcard_match(m,n,s,p);

        //TABULATION
        boolean[][] dp=new boolean[m+1][n+1];
        //first base case
        dp[0][0]=true;
        //second base case
        for(int i=1;i<m+1;i++){
            dp[i][0]=false;
        }
        //third base case
        for(int j=1;j<n+1;j++){
            if(p.charAt(j-1)!='*'){
                break;
            }
            dp[0][j]=true;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]= dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[m][n];

    }
    private static boolean wildcard_match(int m,int n,String s,String p){
        if(m==0 && n==0){
            return true;
        }
        if(n==0 && m>0){
            return false;
        }
        if(m==0 && n>0){
            for(int i=0;i<n;i++){
                if(p.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }

        if(s.charAt(m-1)==p.charAt(n-1) || p.charAt(n-1)=='?'){
            return wildcard_match(m-1,n-1,s,p);
        }else if(p.charAt(n-1)=='*'){

            // boolean ans=false;
            // for(int i=m;i>=0;i--){
            //     ans=ans||wildcard_match(i,n-1,s,p,dp);
            // }
            // return ans;
            return wildcard_match(m,n-1,s,p) ||   wildcard_match(m-1,n,s,p);
        }else{
            return false;
        }

    }

}
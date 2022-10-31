public class zl_longestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int n=words.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,-1,words,dp);

        //TABULATION
         int n=words.length;
         int[][] dp=new int[n+1][n+1];
         for(int cur_ind=n-1;cur_ind>=0;cur_ind--){
             for(int prev_ind=cur_ind-1;prev_ind>=-1;prev_ind--){
                 int not_pick=dp[cur_ind+1][prev_ind+1];
                 int pick=0;
                 if(prev_ind==-1 || ifpossible(words[cur_ind],words[prev_ind])){
                     pick= 1+dp[cur_ind+1][cur_ind+1];
                 }
                 dp[cur_ind][prev_ind+1]=Math.max(pick,not_pick);
             }
         }
         return dp[0][-1+1];

    }
    private static int solve(int cur_ind,int prev_ind,String nums[],int[][] dp){
        if(cur_ind>=nums.length){
            return 0;
        }
        if(dp[cur_ind][prev_ind+1]!=-1){
            return dp[cur_ind][prev_ind+1];
        }
        int not_pick=solve(cur_ind+1,prev_ind,nums,dp);
        int pick=0;
        if(prev_ind==-1 ||  ifpossible(nums[cur_ind],nums[prev_ind])){
            pick= 1+solve(cur_ind+1,cur_ind,nums,dp);
        }

        return dp[cur_ind][prev_ind+1]=Math.max(pick,not_pick);


    }
    private static boolean ifpossible(String cur_word,String prev_word){
        if(cur_word.length()<=prev_word.length()){
            return false;
        }
        int first=0;
        int second=0;
        int diff_count=0;
        while(first<cur_word.length()){
            if(second<prev_word.length() && cur_word.charAt(first)==prev_word.charAt(second)){
                first++;
                second++;
            }else{
                diff_count++;
                first++;
            }
        }
        if(diff_count>1){
            return false;
        }
        if(second==prev_word.length()){
            return true;
        }
        return false;

    }

}
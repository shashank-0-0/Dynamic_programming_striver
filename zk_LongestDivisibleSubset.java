public class zk_LongestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        ArrayList<Integer> res=new ArrayList();
        solve1(0,-1,new ArrayList<Integer>(),nums,res,dp);
        return res;

    }

    //optimization
    //draw recursive treee for ex:1 4 3 8 you will understand (easy hai)
    private static void solve1(int n,int prev,ArrayList<Integer> list,int[] nums,ArrayList<Integer> res,int[] dp){

        if(n>=nums.length){
            if(list.size()>res.size()){
                res.clear();
                res.addAll(list);
            }
            return;
        }

        //pick
        if( list.size()>dp[n] && (prev==-1 || nums[n]%nums[prev]==0)){
            dp[n]=list.size();
            list.add(nums[n]);
            solve1(n+1,n,list,nums,res,dp);
            list.remove(list.size()-1);
        }
        //notpick
        solve1(n+1,prev,list,nums,res,dp);
    }

}
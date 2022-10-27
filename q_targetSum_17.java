
public class q_targetSum_17 {

    // Boils down to two subset with a given difference problem.

    //This is another simple approach.
    //At each element you have to choice either u add it or subtract simple
    public int findTargetSumWays(int[] nums, int target) {

        int n=nums.length;
        return solve(nums.length,target,nums,dp);
}
    private static  int solve(int n,int target,int[] nums,int[][]dp){

        if(n<=0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        int add=solve(n-1,target-nums[n-1],nums,dp);
        int subtract=solve(n-1,target+nums[n-1],nums,dp);
        return add+subtract;
    }

}
public class zm_longestBitonicSubsequence {
    public static int longestBitonicSequence(int[] nums, int n) {
        // Write your code here.

        int ans=0;
        int[] LIS=new int[n];
        Arrays.fill(LIS,1);
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    LIS[i]=Math.max(LIS[i],1+LIS[j]);
                }
            }
        }
        //LIS[i] represents  longest increasing subsequence from 0 to i
        int[] LIS1=new int[n];
        Arrays.fill(LIS1,1);
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    LIS1[i]=Math.max(LIS1[i],1+LIS1[j]);
                }
            }
        }
        //LIS1[i] represents  longest increasing subsequence from i to n in reverse order

        for(int i=0;i<n;i++){
            ans=Math.max(ans,LIS[i]+LIS1[i]-1);
        }
        return ans;
    }
}
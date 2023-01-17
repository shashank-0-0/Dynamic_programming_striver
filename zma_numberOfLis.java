 public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] LIS=new int[n];
        int[] count=new int[n];
        Arrays.fill(LIS,1);
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(LIS[i]<1+LIS[j]){
                        LIS[i]=1+LIS[j];
                        count[i]=count[j];
                    }else if(LIS[i]==1+LIS[j]){
                        count[i]+=count[j];
                    }
                }
            }
        }
        int lis=0;
        int ans=0;
        for(int i=0;i<LIS.length;i++){ 
            if(LIS[i]>lis){
                lis=LIS[i];
                ans=count[i];
            }else if(LIS[i]==lis){
                ans+=count[i];
            }
        }
        // for(int i=0;i<LIS.length;i++){
            // if(LIS[i]==lis){
                // ans+=count[i];
            // }
        // }
        return ans;
    }
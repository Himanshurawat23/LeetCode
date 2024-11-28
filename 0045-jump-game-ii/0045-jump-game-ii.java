class Solution {
    public int call(int nums[],int n,int i,int dp[]){
        if(i>=n)return 0;
        if(nums[i]==0)return Integer.MAX_VALUE;
        if(dp[i]!=-1)return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            int jum=call(nums,n,i+j,dp);
            if(jum!=Integer.MAX_VALUE){
                min=Math.min(min,1+jum);
            }
        }
               return dp[i]=min;
    }
    public int jump(int[] nums) {
     
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return call(nums,nums.length-1,0,dp);
    }
}
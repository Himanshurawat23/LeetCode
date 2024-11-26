class Solution {
    public int call(int a[],int dp[],int n){
        if(n<0)return 0;
        if(n==0)return a[n];
        if(dp[n]!=-1)return dp[n];
        
        int take = a[n]+call(a,dp,n-2);
        int notake=call(a,dp,n-1);
        return dp[n]=Math.max(take,notake);
    }
    public int rob(int[] nums) {
        
        
        int n=nums.length;
        if(n==1)return nums[0];
        int dp1[] = new int[n-1];
        int dp2[] = new int[n-1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int a1[] = new int[n-1];
        int a2[] = new int[n-1];
        for(int i=0;i<n-1;i++){
            a1[i]=nums[i];
        }
        for(int i=1;i<n;i++){
            a2[i-1]=nums[i];
        }
        return Math.max(call(a1,dp1,n-2),call(a2,dp2,n-2));
    }
}
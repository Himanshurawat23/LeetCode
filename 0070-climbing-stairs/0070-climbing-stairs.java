class Solution {
    public int call(int dp[],int n){
      if(n==1 || n==0)return 1;
      if(dp[n]!=-1)return dp[n];
      return dp[n]=call(dp,n-1)+call(dp,n-2);
      
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return call(dp,n);
    }
}
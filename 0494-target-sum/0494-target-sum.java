class Solution{ 
    public static int call(int nums[], int i,int s,int target){
        if(i==nums.length){
            if(s==target){
                return 1;
            }
            return 0;
        }
        int a=call(nums,i+1,s+nums[i],target);
        int b=call(nums,i+1,s-nums[i],target);
        return a+b;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return call(nums,0,0,target);
    }
}
class Solution {
    public int call(int nums[],int k,int ch){
        int e=0;
        int s=0;
        int max=Integer.MIN_VALUE;
        int flip=0;
        while(e<nums.length){
            if(nums[e]==ch)flip++;
            while(flip>k){
                if(nums[s]==ch)flip--;
                s++;
            }
            max=Math.max(max,e-s+1);
            e++;
        }
        return max;
    }
    public int longestOnes(int[] nums, int k) {
        return call(nums,k,0);
    }
}
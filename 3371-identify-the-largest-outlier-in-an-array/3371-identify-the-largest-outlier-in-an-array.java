class Solution {
    public int getLargestOutlier(int[] nums) {
        int max=Integer.MIN_VALUE;
        int ans=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(var a:nums){
            ans+=a;
            mp.put(a,mp.getOrDefault(a,0)+1);
        }
        for(int i=0;i<nums.length;i++){
           if((ans-nums[i])%2==0){
            mp.put(nums[i],mp.get(nums[i])-1);
             if(mp.get(nums[i])==0){
                mp.remove(nums[i]);
             }
             if(mp.containsKey((ans-nums[i])/2))
             max=Math.max(max,nums[i]);
             mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
           }   
        }
        

        return max;
    }
}
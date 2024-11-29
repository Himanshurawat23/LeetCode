class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
       int a[][] = new int[nums1.length][2];
       for(int i=0;i<nums1.length;i++){
           a[i][0]=nums1[i];
           a[i][1]=nums2[i];
       }
        Arrays.sort(a,(b,c)->Integer.compare(c[1],b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long s=0;
        long max=Long.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            s+=a[i][0];
            pq.add(a[i][0]);
            if(pq.size()==k){
                max=Math.max(max,s*a[i][1]);
                s-=pq.poll();
            }
            
        }
        return max;
       
    }
}
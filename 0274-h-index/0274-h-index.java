class Solution {
    public int hIndex(int[] cit) {
        Arrays.sort(cit);
        int n=cit.length;
        for(int i=0;i<n;i++){
            if((n-i)<=cit[i]){
                return n-i;
            }
        }
        return 0;
    }
}
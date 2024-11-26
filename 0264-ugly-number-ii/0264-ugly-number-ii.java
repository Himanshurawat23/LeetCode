class Solution {
    public int nthUglyNumber(int n) {
        int i2=1;
        int i3=1;
        int i5=1;
        int ug[] = new int[n+1];
        ug[1]=1;
        for(int i=2;i<=n;i++){
            int i2ug=ug[i2]*2;
            int i3ug=ug[i3]*3;
            int i5ug=ug[i5]*5;
            int min=Math.min(i2ug,Math.min(i3ug,i5ug));
            ug[i]=min;
            if(min==i2ug)
                i2++;
            if(min==i3ug)
                i3++;
            if(min==i5ug)
                i5++;
        }
        return ug[n];
    }
}
class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        int i=0;
        for(var a:nums){
            s[i++]=Integer.toString(a);
        }
        Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
        
        if(s[0].equals("0"))return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<s.length;j++){
            sb.append(s[j]);
        }
        
        return sb.toString();
    }
}
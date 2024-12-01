class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> st = new HashSet<>();
        for(var a:arr){
            int b=a*2;
            int c=-100000;
            if(a%2==0)
             c=a/2;
            if(st.contains(b) || st.contains(c))return true;
            st.add(a);
        }
        return false;
    }
}
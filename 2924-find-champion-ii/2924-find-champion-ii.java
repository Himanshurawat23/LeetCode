class Solution {
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][1]).add(edges[i][0]);
        }
       int c=0;
       int ans=0;
       for(int i=0;i<n;i++){
        if(adj.get(i).size()==0){
            ans=i;
            c++;
       }
       }
       if(c==1)return ans;
       return -1;
    }
}
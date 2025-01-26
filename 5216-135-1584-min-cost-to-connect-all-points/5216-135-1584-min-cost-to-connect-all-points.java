class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        int v=points.length;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<v-1;i++){
            for(int j=i+1;j<v;j++){
                 int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                 adj.get(i).add(new int[]{j,dis});
                 adj.get(j).add(new int[]{i, dis}); 
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        boolean vis[] = new boolean[v];
        pq.add(new int[]{0,0});
        Arrays.fill(vis,false);
        int s=0;
        while(!pq.isEmpty()){
            int p[] = pq.poll();
            int node=p[1];
            int wei=p[0];
            if(vis[node]==true)continue;
            vis[node]=true;
            s+=wei;
            for(int i[]:adj.get(node)){
                if(vis[i[0]]==false){
                    pq.add(new int[]{i[1],i[0]});
                }
            }
        }
        return s;
    }
}
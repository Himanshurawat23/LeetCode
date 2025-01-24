class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int row[] = new int[n];
        int col[]= new int[m];
        // HashMap<int[]> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                row[i]+=grid[i][j];
                // if(grid[i][j]==1){
                //     mp.put(new int[]{i,j});
                // }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(row[i]>1)ans+=row[i];
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                col[i]+=grid[j][i];
            }
        }

        for(int i=0;i<m;i++){
            int nc=0;
            int cc=0;
            if(col[i]>1){
             for(int j=0;j<n;j++){
                if(grid[j][i]==1){
                    if(row[j]>1)nc++;
                     cc++;
                }
             }
             ans+=Math.max(0,cc-nc);
            }
        }
        return ans;

    }
}
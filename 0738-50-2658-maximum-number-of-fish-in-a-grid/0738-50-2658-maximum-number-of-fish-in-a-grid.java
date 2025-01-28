class Solution {
    public void dfs(boolean vis[][],int[][] grid,int c[],int rw,int cl,int n,int m){
        vis[rw][cl]=true;
        c[0]+=grid[rw][cl];
        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};
        for(int i=0;i<4;i++){
            int row=rw+dx[i];
            int col=cl+dy[i];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]>0 && !vis[row][col]){
                dfs(vis,grid,c,row,col,n,m);
            }
        }
    }
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !vis[i][j]){
                    int c[]={0};
                    dfs(vis,grid,c,i,j,n,m);
                    max=Math.max(max,c[0]);
                }
            }
        }
        return max;
    }
}
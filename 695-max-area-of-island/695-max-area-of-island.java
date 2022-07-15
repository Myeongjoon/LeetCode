class Solution {
    int[][] grid = null;
    int current_count = 0;
    int max = 0;
    public void dfs(int i, int j){
        if(this.grid[i][j]==1){
            this.grid[i][j] = 0;
            current_count++;
        }
        int[] x = new int[]{0,0,1,-1};
        int[] y = new int[]{1,-1,0,0};
        for(int jj=0;jj<4;jj++){
            int xx = i + x[jj];
            int yy = j + y[jj];
            if(xx>=0 && xx< this.grid.length && yy>=0 && yy<this.grid[0].length){
                if(this.grid[xx][yy] == 1){
                    dfs(xx,yy);
                }
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(this.grid[i][j]==1){
                    dfs(i,j);
                    max = Math.max(max,current_count);
                    current_count = 0;
                }
            }
        }
        return max;
    }
}
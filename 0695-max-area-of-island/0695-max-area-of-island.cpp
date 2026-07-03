#include<cmath>
class Solution {
public:
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int maxArea=0;
        int m=grid.size();  // row
        int n=grid[0].size();  //col
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    maxArea=max(maxArea, dfs(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    int dfs(vector<vector<int>>& grid, int r, int c){
        if(r<0 || c<0 || r>=grid.size() || c>=grid[0].size()){
            return 0;
        }

        if(grid[r][c] == 0){
            return 0;
        }

        grid[r][c]=0;

        return 1+dfs(grid,r+1,c)+
                 dfs(grid,r-1,c)+
                 dfs(grid,r,c+1)+
                 dfs(grid,r,c-1);
    }
};
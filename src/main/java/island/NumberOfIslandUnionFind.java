package island;

/*
https://leetcode.com/problems/number-of-islands/#/description
 */
public class NumberOfIslandUnionFind {
    private int count = 0;
    private int[] parent;
    private int[] size;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        // Union find implementation
        // number of maximal sets of connected component 
        parent = new int[grid[0].length*grid.length];
        size = new int[parent.length];
        for(int i = 0; i< grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if(grid[i][j]=='1'){
                    parent[grid[i].length*i+j] = grid[i].length*i+j;
                    size[grid[i].length*i+j] = 1;
                    count++;
                }else{
                    parent[grid[i].length*i+j] = -1;
                    size[grid[i].length*i+j] = -1;
                }
            }
        }

        for(int i = 0; i< grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if(grid[i][j]=='1'){
                    if(j < grid[i].length-1 && grid[i][j+1] =='1'){
                        union(grid[i].length*i+j, grid[i].length*i+j+1);
                    }
                    if(i < grid.length-1 && grid[i+1][j] == '1'){
                        union(grid[i].length*i+j, grid[i].length*(i+1)+j);
                    }
                }
            }
        }
        return count;
    }

    private void union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);
        if(rootI != rootJ){
            if(size[rootI] > size[rootJ]){
                parent[rootJ] = rootI;
                size[rootI]+=size[rootJ];
            }else{
                parent[rootI] = rootJ;
                size[rootJ]+=size[rootI];
            }
            count--;
        }
    }

    private int find(int i){
        while(i != parent[i]){
            parent[i]=parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
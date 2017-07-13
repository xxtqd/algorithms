package island;

/**
 * Created by xu_xt on 7/12/17.
 */
public class NumberOfIslandDP {

    private char[][] copyOfGrid;
    public int numIslands(char[][] grid) {
        int island = 0;
        copyOfGrid = grid;
        if(grid.length == 0){
            return 0;
        }
        for (int i = 0; i < copyOfGrid.length; i++){
            for (int j = 0; j < copyOfGrid[i].length; j++){
                if(copyOfGrid[i][j] == '1'){
                    sink(i,j);
                    island ++;
                }
            }
        }
        return island;
    }

    private void sink(int i, int j){
        if(i < 0 || j < 0 || i >= copyOfGrid.length || j >= copyOfGrid[0].length || copyOfGrid[i][j]=='0'){
            return;
        }
        copyOfGrid[i][j] = '0';
        sink(i+1, j);
        sink(i, j+1);
        sink(i-1, j);
        sink(i, j-1);
    }
}

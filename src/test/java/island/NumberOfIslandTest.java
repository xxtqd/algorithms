package island;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfIslandTest {

    @Test
    public void testNumberOfIsland(){

        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid1 = {{'1','1','1','1','1','1','1'},
                {'0','0','0','0','0','0','1'},
                {'1','1','1','1','1','0','1'},
                {'1','0','0','0','1','0','1'},
                {'1','0','1','0','1','0','1'},
                {'1','0','1','1','1','0','1'},
                {'1','1','1','1','1','1','1'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        NumberOfIslandUnionFind noi = new NumberOfIslandUnionFind();
        assertEquals(1, noi.numIslands(grid));
        noi = new NumberOfIslandUnionFind();
        assertEquals(1, noi.numIslands(grid1));
        noi = new NumberOfIslandUnionFind();
        assertEquals(3, noi.numIslands(grid2));

        NumberOfIslandDP noiDP = new NumberOfIslandDP();
        assertEquals(1, noiDP.numIslands(grid));
        noiDP = new NumberOfIslandDP();
        assertEquals(1, noiDP.numIslands(grid1));
        noiDP = new NumberOfIslandDP();
        assertEquals(3, noiDP.numIslands(grid2));
    }

}

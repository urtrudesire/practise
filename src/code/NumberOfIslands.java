package code;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    /**
     *Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * Output: 1
     * Example 2:
     *
     * Input: grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * Output: 3
     */



    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int islands = 0;
        Queue<Cell> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.add(new Cell(i, j));
                    while(!queue.isEmpty()) {
                        Cell cell = queue.poll();
                        checkAndAddNeighbours(cell, grid, visited, queue);
                    }
                    islands++;
                }
            }
        }
        return islands;
    }

    private void checkAndAddNeighbours(Cell cell, char[][] grid, boolean[][] visited, Queue<Cell> queue) {
        int row = cell.row;
        int col = cell.col;
        visited[row][col] = true;
        if(col > 0 && grid[row][col-1] == '1' && !visited[row][col-1]){
            visited[row][col-1] = true;
            queue.add(new Cell(row, col-1));
        }
        if(row > 0 && grid[row-1][col] == '1' && !visited[row-1][col]){
            visited[row-1][col] = true;
            queue.add(new Cell(row-1, col));
        }
        if(row < grid.length-1 && grid[row+1][col] == '1' && !visited[row+1][col]){
            visited[row+1][col] = true;
            queue.add(new Cell(row+1, col));
        }
        if(col < grid[0].length-1 && grid[row][col+1] == '1' && !visited[row][col+1]){
            visited[row][col+1] = true;
            queue.add(new Cell(row, col+1));
        }
    }

    public class Cell{
        int row;
        int col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}

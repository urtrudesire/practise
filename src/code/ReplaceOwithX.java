package code;

public class ReplaceOwithX {

    /*
    You are given a grid[][] of size n*m, where every element is either 'O' or 'X'. You have to replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.
A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

Input:
grid[][] = [['X', 'X', 'X', 'X'],
          ['X', 'O', 'X', 'X'],
          ['X', 'O', 'O', 'X'],
          ['X', 'O', 'X', 'X'],
          ['X', 'X', 'O', 'O']]
Output:
[['X', 'X', 'X', 'X'],
['X', 'X', 'X', 'X'],
['X', 'X', 'X', 'X'],
['X', 'X', 'X', 'X'],
['X', 'X', 'O', 'O']]
Explanation: We only changed those 'O' that are surrounded by 'X'
     */

    public static void fill(char[][] grid) {
        // Code here
        if (grid.length == 0 || grid[0].length == 0) {
            return;
        }
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                char c = grid[i][j];
                if (c == 'O') {
                    boolean checkLeft = checkCell(grid, i, j-1);
                    boolean checkRight = true;
                    if (i == grid.length-1)
                        checkRight = checkCell(grid, i, j+1);

                    boolean checkUp = checkCell(grid, i-1, j);
                    boolean checkDown = true;
                    if (j == grid[0].length-1)
                        checkDown = checkCell(grid, i+1, j);
                    if (checkLeft && checkRight && checkUp && checkDown) {
                        grid[i][j] = 'X';
                    }
                }
            }
        }
    }

    private static boolean checkCell(char[][] grid, int row, int col) {
        return grid[row][col] == 'X';
    }

    public static void main(String[] args) {
        char[][] grid = {{'X', 'O', 'X', 'X'}, {'X', 'O', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}, {'X', 'X', 'O', 'O'}};
        fill(grid);
        for (char[] chars : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

}

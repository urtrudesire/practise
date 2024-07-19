package code;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {

    /**
     *Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
     *
     * You must do it in place.
     *
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     */

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(rows.contains(i)){
                    matrix[i][j] = 0;
                    continue;
                }
                if(cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

package code;

import java.util.List;

public class MagicSquare {

    /*
    We define a magic square to be an n*n matrix of distinct positive integers from  1 to n2 where the sum of any row, column, or diagonal of length  is always equal to the same number: the magic constant.

You will be given a 3*3 matrix s of integers in the inclusive range . We can convert any digit  to any other digit  in the range  at cost of . Given , convert it into a magic square at minimal cost. Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range .

Example

$s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]

The matrix looks like this:

5 3 4
1 5 8
6 4 2
We can convert it to the following magic square:

8 3 4
1 5 9
6 7 2
This took three replacements at a cost of |5-8|+ |8-9| + |4-7| = 7.
     */

    public int formingMagicSquare(List<List<Integer>> s) {
        int sum = 0;
        for (int row = 0; row < s.size(); row++) {
            for (int col = 0; col < s.get(0).size(); col++) {
                int rSum = getRowSum(s, row, col);
                int cSum = getColumnSum(s, row, col);
                if (row == col) {
                    int dSum = getDiagonalSum(s, row, col);
                    if (rSum == 15 || cSum == 15 || dSum == 15)
                        continue;
                } else {
                    if (rSum == 15 || cSum == 15)
                        continue;
                }
                int diff = 15 - rSum;
                if (s.get(row).get(col) + diff > 0 && s.get(row).get(col) + diff < 10) {
                    sum += Math.abs(diff);
                    s.get(row).set(col, s.get(row).get(col) + diff);
                }
            }
        }
        return sum;
    }

    private int getDiagonalSum(List<List<Integer>> s, int row, int col) {
        int r = row;
        int c = col;
        int sum = s.get(row).get(col);
        while (r-1 >= 0) {
            r--;
            c--;
            sum += s.get(r).get(c);
        }
        r= row;
        c= col;
        while (r+1 < s.size() ) {
            r++;
            c++;
            sum += s.get(r).get(c);
        }
        return sum;
    }

    private int getColumnSum(List<List<Integer>> s, int row, int col) {
        int r = row;
        int sum = s.get(row).get(col);
        while (r-1 >= 0){
            r--;
            sum += s.get(r).get(col);
        }
        r = row;
        while (r+1 < s.size()){
            r++;
            sum += s.get(r).get(col);
        }
        return sum;
    }

    private int getRowSum(List<List<Integer>> s, int row, int col) {
        int c = col;
        int sum = s.get(row).get(col);
        while (c-1 >= 0){
            c--;
            sum += s.get(row).get(c);
        }
        c = col;
        while (c+1 < s.get(0).size()){
            c++;
            sum += s.get(row).get(c);
        }
        return sum;
    }
}

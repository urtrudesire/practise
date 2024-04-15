package Code;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] x : matrix){
            for(int s : x){
                System.out.print(s + " " );
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix){
        int[][] res = new int[matrix.length][matrix.length];
        for(int i = 0 ; i < matrix.length; i++){
            for (int j = matrix.length-1 ; j > -1; j--){
                res[i][matrix.length-1 - j] = matrix[j][i];
            }
        }
        for(int i = 0; i < matrix.length; i++){
            System.arraycopy(res[i], 0, matrix[i], 0, matrix.length);
        }
    }
}

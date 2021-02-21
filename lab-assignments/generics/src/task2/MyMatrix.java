package task2;

import java.util.Arrays;

public class MyMatrix implements Summable {
    private final int[][] matrix;

    public MyMatrix() {
        this.matrix = new int[4][4];
    }

    public MyMatrix(final int[][] matrix) {
        if (matrix.length == 4 && matrix[0].length == 4) {
            this.matrix = matrix;
        } else {
            this.matrix = new int[4][4];
        }
    }

    @Override
    public void addValue(final Summable value) {
        if (value instanceof MyMatrix) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <=3 ; j++) {
                    this.matrix[i][j] += ((MyMatrix) value).matrix[i][j];
                }
            }
        }
    }

    @Override
    public String toString() {
        return "MyMatrix{" +
                "matrix=" + Arrays.deepToString(matrix) +
                '}';
    }
}

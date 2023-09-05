import java.util.*;

class Solution {
    public int diagonalSum(int[][] mat) {
        int[][] mat2 = mat;
        ;
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == j || i + j == mat.length - 1) {
                    sum = sum + mat[i][j];
                }
            }

        }
        return sum;
    }
}
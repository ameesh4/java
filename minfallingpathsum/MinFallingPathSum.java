package minfallingpathsum;
import java.util.Arrays;

class Solution{
    public int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        int r = n-2;
        int n2 = matrix[0].length;
        if (r == -1){
            return min(matrix[0]);
        }

        for (int c = 0; c < n2; c++){
            if (c == 0){
                int[] arr = new int[]{matrix[r+1][c], matrix[r+1][c+1]};
                matrix[r][c] += min(arr);
            }else if (c == n2 - 1){
                int[] arr = new int[]{matrix[r+1][c], matrix[r+1][c-1]};
                matrix[r][c] += min(arr);
            }else{
                int[] arr = new int[]{matrix[r+1][c], matrix[r+1][c+1], matrix[r+1][c-1]};
                matrix[r][c] += min(arr);
            }
        }
        matrix = Arrays.copyOf(matrix, n-1);
        return this.minFallingPathSum(matrix);
    }
    
    public int min(int[] a){
        int min = a[0];
        int i = 0;
        while (i < a.length){
            if (min > a[i]){
                min = a[i];
            }
            i++;
        }
        return min;
    }
}


public class MinFallingPathSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = new int[][]{{-19, 57, 18, 19}, {-40,-5, 16, -20}, {41, 32, 21, -41}, {22, 33, 44, 55}};
        System.out.println(sol.minFallingPathSum(arr));
    }
}

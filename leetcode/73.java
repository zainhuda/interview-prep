class Solution {
    // "sink" methodology
    // we scour the matrix for zeros, and use the first row and cols as "boolean flags" to zero a col/row 
    // then we do it 
    public void setZeroes(int[][] matrix) {
        boolean colClear = false;
        if (matrix[0][0] == 0) colClear = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        colClear = true;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        // now we begin sinking process 
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colClear) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
    
}
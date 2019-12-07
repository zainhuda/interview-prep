class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         // start from the top right and  iteratively keep going until we find or dont find it 
        if (matrix.length < 1) return false;
        int i = 0;
        int j = matrix[0].length-1;
        while (i >= 0 && j >= 0 && i <= matrix.length-1 && j <= matrix[0].length-1) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return false;
            }
        }
        return false;
    }
}
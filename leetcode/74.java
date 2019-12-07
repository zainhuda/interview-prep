class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) return false;
        // two b searches
        // one for col
        // one for row
        int row = rowBSearch(matrix, target);
        if (row == -1) return false;
        int col = colBSearch(matrix, target, row);
        return col != -1;
    }
    
    public int rowBSearch(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target) return mid;
            if (target < matrix[mid][0]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    
    public int colBSearch(int[][] matrix, int target, int row) {
        int low = 0;
        int high = matrix[0].length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (matrix[row][mid] == target) return mid;
            if (target < matrix[row][mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
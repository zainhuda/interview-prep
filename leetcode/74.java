class Solution {
    // binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rowlen = matrix[0].length-1;
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][rowlen]) {
                if (search(matrix[i], target)) return true;
            }
        }
        return false;
    }
    
    private boolean search(int[] row, int target) {
        int lo = 0;
        int hi = row.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (row[mid] == target) return true;
            if (row[mid] > target) hi = mid-1;
            if (row[mid] < target) lo = mid+1;
        }
        return false;
    }
}

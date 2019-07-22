class Solution {
    // if target is in the range of the row, we binary search for value 
    // do this for all possible rows 
    // O(nlogn)
    // can do this faster probably
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rowlen = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][rowlen-1] >= target) {
                if (search(matrix[i], target)) return true;
            }
        }
        return false;
    }
    
    public boolean search(int[] row, int target) {
        int left = 0;
        int right = row.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (row[mid] == target) return true;
            if (row[mid] > target) right = mid-1;
            if (row[mid] < target) left = mid+1;
        }
        return false;
    }
}

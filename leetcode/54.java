class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix.length == 0) return order;
        int i, r = 0, c = 0;
        // r is row start
        // c is col start
        int m =  matrix.length; // row end
        int n = matrix[0].length; // col end
        while (r < m && c < n) {
            for (i = c; i < n; i++) {
                order.add(matrix[r][i]);
            }
            r++;
            for (i = r; i < m; i++) {
                order.add(matrix[i][n-1]);
            }
            n--;
            if (r < m) {
                for (i = n-1; i >= c; i--) {
                    order.add(matrix[m-1][i]);
                }
                m--;
            }
            if (c < n) {
                for (i = m-1; i >= r; i--) {
                    order.add(matrix[i][c]);
                }
                c++;
            }
        }
        return order;
    }
}

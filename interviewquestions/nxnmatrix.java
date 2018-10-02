public class Main {

    /*
    I want to input a matrix size N x N and cut a slice such that each element is directly below,
    left-below or right-below the one above it. And cost is the sum of all elements in the slice.
    How do I write a program to do this?
     */

    public static void main(String[] args) {
	    int[][] matrix = new int [3][3];



	    //Filling the Matrix
	    int initialCounter = 1;
	    for (int i=0 ;i<matrix.length; i++){
	        for (int j=0; j<matrix[0].length; j++){
	            matrix[i][j] = initialCounter++;
            }
        }


        int result = minPathSum(matrix);
        System.out.println("Minimun Path Sum: " + result);

    }



    public static int minPathSum(int[][] n){
        // n = original matrix
        // c = cost matrix

        int[][] c = new int[n.length][n[0].length];

        // copy over first row because problem can only go downwards

        for (int i=0; i<n.length; i++){
            c[0][i] = n[0][i];
        }



        for (int i=1; i<n.length; i++){
            for (int j=0; j<n[0].length; j++){

                //out of bounds checking
                int x = Integer.MAX_VALUE;
                int y = Integer.MAX_VALUE;
                int z = Integer.MAX_VALUE;

                if (j-1 >= 0){
                    x = c[i-1][j-1];
                }
                if (j+1 < n[0].length){
                    z = c[i-1][j+1];
                }
                y = c[i-1][j];


                c[i][j] = n[i][j] + Math.min(Math.min(x,y),z);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<c[c.length-1].length; i++){
            min = Math.min(min, c[c.length-1][i]);
        }

        return min;
    }
}

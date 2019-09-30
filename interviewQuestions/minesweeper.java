import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

r - rows
c - cols
n - mines

------
------
------
------
------
------

......
....x.
...x..
......
.x....
......

...111
..12x1
..1x21
11211.
1x1...
111...

-----1
------
----21
--211.
--1...
--1...

generatePosition() -> row, col

public class Solution {
    
    public static int[][] checker(int x, int y) {
        if (x < 0 || y  < 0  || y >= matrix.length || x >= matrix[0].length) throw new IllegalArgumentException();
        if (checker[y][x] == -1) {
            return magicalFunction();
        }
        if (checker[y][x] != 0) {
            matrix = revealFunction(matrix, x, y);
            return matrix;
        }
        
        dfs(matrix, x, y)
        
    }
    
    private void dfs(int[][] matrix, int x, int y) {
        revealFunction(matrix, x, y);
        if (matrix[y][x] != 0) return;
        // Continue our dfs if coordinate is 0
        if (x-1 >= 0) dfs(matrix, x-1, y);
        if (y-1 >= 0) dfs(matrix, x, y-1);
        if (x+1 < matrix[0].length) dfs(matrix, x+1, y);
        if (y+1 < matrix.length) dfs(matrix, x, y+1);

    }
    
    
    
    public static void solution(int row, int col, int mines) {
        int[][] matrix = new int[row][col];
        Set<Tuple> placed = new HashSet<>();
        // Check to make sure mines is correct
        while (mines > 0) {
            Tuple coordinate = generatePosition();
            if (!set.contains(coordinate)) {
                set.add(coordinate);
                matrix[coordinate.y][coordinate.x] = -1;
                if (coordinate.y-1 >= 0 && matrix[coordinate.y-1][coordinate.x] != -1) matrix[coorindate.y-1][coordinate.x]++;
                if (coordinate.y+1 < row && matrix[coordinate.y+1][coordinate.x] != -1) matrix[coorindate.y+1][coordinate.x]++;
                if (coordinate.x-1 >= 0 && matrix[coordinate.y][coordinate.x-1] != -1) matrix[coorindate.y][coordinate.x-1]++;
                if (coordinate.x-1 >= 0 && matrix[coordinate.y][coordinate.x-1] != -1) matrix[coorindate.y][coordinate.x-1]++;
                mines--;
            } 
        }
        
    }
    
    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");
    }
}
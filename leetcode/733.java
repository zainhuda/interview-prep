class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // classfic dfs,  we just replace it with new color
        if (image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, sr,  sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int sr, int sc, int target, int newColor) {
        if (i < 0 || j < 0 || i > image.length-1 || j > image[0].length-1) {
            return;
        }
        if (image[i][j] == target) {
            image[i][j] = newColor;
            dfs(image, i-1, j, sr, sc, target, newColor);
            dfs(image, i, j-1, sr, sc, target, newColor);
            dfs(image, i+1, j, sr, sc, target, newColor);
            dfs(image, i, j+1, sr, sc, target, newColor);
        } 
        return;
    } 
}
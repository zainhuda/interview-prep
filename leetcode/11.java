class Solution {
    public int maxArea(int[] height) {
        // classic two pointer action here
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right) {
            int len = right - left;
            max = Math.max(len*Math.min(height[left], height[right]), max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        
        return max;
    }
}

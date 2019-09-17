class Solution {
    public int trap(int[] height) {
        // another classic two pointer approach
        // similar to max area
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length-1;
        int water = 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
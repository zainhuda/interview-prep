class Solution {
    public int trap(int[] height) {
        int leftmax = 0, rightmax = 0;
        int left = 0, right = height.length-1;
        int totalWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                 if (height[left] >= leftmax) {
                    leftmax = height[left];
                 } else {
                     totalWater += leftmax - height[left];
                 }
                left++;
            } else {
                if (height[right] >= rightmax) {
                    rightmax = height[right];
                } else {
                    totalWater += rightmax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}

/*
CHECK WHY THIS DOESNT WORK
class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int i = 0;
        while (i < height.length) {
            System.out.println(getIndex(i, height));
            if (height[i] == 0 && i == 0) {
                i++;
            }
            totalWater += computeWater(i, height);
            i = getIndex(i, height);
        }
        return totalWater;
    }

    int computeWater(int startingIndex, int[] array) {
        int endingIndex = getIndex(startingIndex, array);
        int startingHeight = array[startingIndex];
        int totalArea;
        int elevationHeight = 0;
        for (int i = startingHeight + 1; i < endingIndex; i++) {
            if (i == array.length - 1) {
                if (array[i] >= startingHeight) {
                    elevationHeight += array[i];
                    break;
                } else {
                    return 0;
                }
            } else {
                elevationHeight += array[i];
            }
        }
        totalArea = startingHeight * (startingIndex - endingIndex - 1);
        return totalArea - elevationHeight;
    }

    int getIndex(int startingIndex, int[] array) {
        if (startingIndex == 0) return startingIndex + 1;
        int startingHeight = array[startingIndex];
        int endingIndex = startingIndex;
        for (int i = startingIndex; i < array.length; i++) {
            if (array[i] >= startingHeight) {
                endingIndex = i;
                return endingIndex;
            }
        }
        return endingIndex;
    }
}
*/

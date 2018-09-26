class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> intersectionArray = new HashSet<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0; //counter for nums1
        int k = 0; //counter for nums2
        
        while (i < nums1.length && k < nums2.length) {
            if (nums1[i] < nums2[k]) {
                i++;
            } else if (nums1[i] > nums2[k]) {
                k++;
            } else {
                intersectionArray.add(nums2[k]);
                i++;
                k++;
            }
        }
        
        int j = 0;
        int[] returnArray = new int[intersectionArray.size()];
        for (Integer num: intersectionArray) {
            returnArray[j++] = num; 
        }
        
        return returnArray;
        
    }
}
import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++) list.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++) list.add(nums2[i]);

        Collections.sort(list);
        int s = list.size();
        if(s % 2 == 0) {
            double a = list.get(s / 2 - 1);
            double b = list.get(s / 2);
            result = (a + b) / 2;
        }else {
            double d = list.get(s / 2);
            result = d;
        }
        return result;
    }
}
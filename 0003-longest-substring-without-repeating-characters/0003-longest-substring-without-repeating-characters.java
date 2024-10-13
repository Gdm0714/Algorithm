import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        int end = 0;

        while(end < s.length()) {
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }else{
                set.add(s.charAt(end));
                max = Math.max(max, end - start + 1);
                end++;
            }
        }
        return max;
    }
}
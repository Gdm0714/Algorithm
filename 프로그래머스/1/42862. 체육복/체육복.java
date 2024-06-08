import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        
        for (int i : reserve) 
            students[i]++;
        for (int i : lost) 
            students[i]--;
        
        for (int i = 1; i <= n; i++) {
            if (students[i] == -1) {
                if (i-1 >= 1 && students[i-1] == 1) {
                    students[i]++;
                    students[i-1]--;
                } else if (i+1 <= n && students[i+1] == 1) {
                    students[i]++;
                    students[i+1]--;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] != -1) 
                answer++;
        }
        
        return answer;
    }
}
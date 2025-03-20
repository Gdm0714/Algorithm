import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];
        int num = 1;
        
        for(int i = 0; i < sequence.length; i++){
            arr1[i] = sequence[i] * num;
            num *= -1;
            arr2[i] = sequence[i] * num;
        }
        
        answer = Math.max(calculate(arr1), calculate(arr2));
        
        return answer;
    }
    
    long calculate(int[] arr){
        long[]dp = new long[arr.length];
        dp[0] = arr[0];
        long max = dp[0];
        
        for(int i = 1; i < arr.length; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
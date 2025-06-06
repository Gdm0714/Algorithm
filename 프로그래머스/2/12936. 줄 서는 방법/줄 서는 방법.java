import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        long[] factorial = new long[21];
        factorial[0] = 1;
        for (int i = 1; i <= 20; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        int[] result = new int[n];
        
        k--;
        
        for (int i = 0; i < n; i++) {
            int index = (int)(k / factorial[n - i - 1]);
            result[i] = numbers.get(index);
            numbers.remove(index);
            k %= factorial[n - i - 1];
        }
        
        return result;
    }
}
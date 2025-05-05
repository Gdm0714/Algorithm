import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        final int colIdx = col - 1;
        
        Arrays.sort(data, (a, b) -> {
            if (a[colIdx] != b[colIdx]) {
                return Integer.compare(a[colIdx], b[colIdx]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        int hash = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int s_i = 0;
            for (int value : data[i-1]) {
                s_i += value % i;
            }
            hash ^= s_i;
        }
        
        return hash;
    }
}
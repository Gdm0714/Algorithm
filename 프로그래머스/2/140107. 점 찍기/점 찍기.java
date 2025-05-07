class Solution {
    public long solution(int k, int d) {
        long count = 0;
        
        for (int x = 0; x <= d; x += k) {
            long maxY = (long)Math.sqrt((long)d*d - (long)x*x);
            
            count += (maxY / k) + 1;
        }
        
        return count;
    }
}
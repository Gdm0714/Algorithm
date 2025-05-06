import java.util.PriorityQueue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> usedInvincibility = new PriorityQueue<>();
        
        long remainingSoldiers = n;
        
        for (int round = 0; round < enemy.length; round++) {
            int currentEnemies = enemy[round];
            
            usedInvincibility.add(currentEnemies);
            
            if (usedInvincibility.size() > k) {
                remainingSoldiers -= usedInvincibility.poll();
            }
            
            if (remainingSoldiers < 0) {
                return round;
            }
        }
        
        return enemy.length;
    }
}
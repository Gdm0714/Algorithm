import java.util.*;

class Solution {
    public TreeSet<Integer> solution(int[] numbers) {
        int[] answer = {};
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i != j){
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        return set;
    }
}
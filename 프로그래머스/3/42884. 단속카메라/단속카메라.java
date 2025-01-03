import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0] - b[0];
            }
        } );
        
        int end = routes[0][1];
        
        for(int i = 0; i < routes.length; i++){
            if (routes[i][0] > end) {
                answer++;
                end = routes[i][1];
            }
            if(routes[i][1] < end){
                end = routes[i][1];
            }
        }
        
        return answer;
    }
}
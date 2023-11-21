package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalculateScore {
    public static int solution(int[] num) {
        int result = 0;
        int cnt = 0;
        for(int i = 0; i<num.length; i++){
            if(num[i] == 1){
                cnt++;
                result += cnt;
            }
            else{
                cnt = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(num));
    }
}

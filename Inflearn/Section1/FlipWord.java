package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipWord {
    public static String solution(String s){
        String result = "";
        for(int i =s.length()-1; i>=0; i--){
            result += s.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] s = new String[n];
        for(int i = 0; i<n; i++){
            System.out.println(solution(br.readLine()));
        }

    }
}

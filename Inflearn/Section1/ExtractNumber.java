package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractNumber {
    public static int solution(String s){
        int result;
        s = s.replaceAll("[^0-9]", "");
        result = Integer.valueOf(s);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}

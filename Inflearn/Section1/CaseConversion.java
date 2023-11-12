package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaseConversion {

    public static String solution(String s) {
        String result = "";
        for(int i = 0; i<s.length(); i++){
            if(Character.isUpperCase(s.charAt(i)))
                result += Character.toLowerCase(s.charAt(i));
            else
                result += Character.toUpperCase(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}

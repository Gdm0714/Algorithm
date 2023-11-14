package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InquiryChar {
    public static String solution(String s) {
        char[] c = s.toCharArray();
        boolean b = true;
        for (int i = 0; i < c.length / 2; i++) {
            int j = c.length - i - 1;
            if(Character.toUpperCase(c[i]) != Character.toUpperCase(c[j])) {
                b = false;
            }
        }
        if(b)
            return "YES";
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}

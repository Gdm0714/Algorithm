package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Password {

    public static String solution(int n, String s) {
        String result = "", st = "";
        s = s.replace('#', '1');
        s = s.replace('*', '0');
        int[] binary = new int[n];

        char c;
        for (int i = 0; i < n; i++) {
            st = "";
            for (int j = i * 7; j < (i + 1) * 7; j++) {
                st += s.charAt(j);
            }
            binary[i] = Integer.parseInt((st), 2);
            c = (char) binary[i];
            result += c;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(solution(n, s));
    }
}

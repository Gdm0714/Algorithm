package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FlipCertainWord {

    public static String solution(String s) {

        char[] c = s.toCharArray();
        ArrayList<Character> replace = new ArrayList<>();
        int[] num = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
                num[i] = 1;
                replace.add(s.charAt(i));
            }
        }

        int index = replace.size();
        for (int i = 0; i < s.length(); i++) {
            if (num[i] != 0) {
                c[i] = replace.remove(index - 1);
                index--;
            }
        }
        s = String.valueOf(c);
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}

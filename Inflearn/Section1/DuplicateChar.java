package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DuplicateChar {
    public static String solution(String s) {
        char[] c = s.toCharArray();
        String result = "";
        for (int i = 0; i < c.length; i++) {
            if(!result.contains(Character.toString(c[i]))){
                result += Character.toString(c[i]);
            }
        }
        return result;
    }

        public static void main (String[]args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println(solution(s));
        }
    }

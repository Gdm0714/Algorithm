package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class CompressString {
    public static void solution(String s) {
        char[] c = s.toCharArray();
        int cnt = 1;
        ArrayList<Character> result = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++) {

            if (c[i] == c[i + 1]) {
                cnt++;
            } else {
                result.add(c[i]);
                if (cnt > 1)
                    result.add(Integer.toString(cnt).charAt(0));
                cnt = 1;
            }
        }

        Iterator<Character> it = result.iterator();
        while (it.hasNext()) {
            char ch = it.next();
            System.out.print(ch);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine() + " ";
        solution(s);
    }
}

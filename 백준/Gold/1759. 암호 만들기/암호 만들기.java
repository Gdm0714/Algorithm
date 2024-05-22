import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] chars;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        makePassword("", 0, 0, 0);
    }

    static void makePassword(String password, int index, int vowel, int consonant) {
        if (password.length() == L) {
            if (vowel >= 1 && consonant >= 2) {
                System.out.println(password);
            }
            return;
        }
        if (index >= C) {
            return;
        }
        if (chars[index] == 'a' || chars[index] == 'e' || chars[index] == 'i' || chars[index] == 'o' || chars[index] == 'u') {
            makePassword(password + chars[index], index + 1, vowel + 1, consonant);
        } else {
            makePassword(password + chars[index], index + 1, vowel, consonant + 1);
        }
        makePassword(password, index + 1, vowel, consonant);
    }
}
package n14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Stack<String> text = new Stack<>();

        for (int i = 0; i < n; i++) {
            text.push(br.readLine());
        }

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            Iterator<String> it = text.iterator();

            while (it.hasNext()) {
                if (s.equals(it.next()))
                    cnt++;

            }
        }
        System.out.println(cnt);
    }
}

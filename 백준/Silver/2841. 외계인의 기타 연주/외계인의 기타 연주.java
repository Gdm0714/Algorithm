import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Stack<Integer>[] finger = new Stack[6];
        for (int i = 0; i < finger.length; i++) {
            finger[i] = new Stack<>();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!finger[line - 1].isEmpty() && finger[line - 1].peek() > fret) {
                finger[line - 1].pop();
                answer++;
            }
            if (finger[line - 1].isEmpty() || finger[line - 1].peek() != fret) {
                finger[line - 1].push(fret);
                answer++;
            }
        }
        System.out.println(answer);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = -1;
    static int n;
    static boolean[][] com;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        com = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];

        int num1, num2;

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            com[num1][num2] = com[num2][num1] = true;
        }

        virus(1);

        System.out.println(cnt);
    }

    static void virus(int num) {
        check[num] = true;
        cnt++;
        for (int i = 1; i <= n; i++) {
            if (com[num][i] && !check[i]) {
                virus(i);
            }
        }
    }
}
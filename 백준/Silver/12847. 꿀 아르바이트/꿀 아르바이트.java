import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] money = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += money[i];
        }

        long max = sum;

        for (int i = m + 1; i <= n; i++) {
            sum = sum + money[i] - money[i - m];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long left = 0, right = n;

        while (left <= right) {
            long v = (left + right) / 2;
            long h = n - v;
            long p = (v + 1) * (h + 1);

            if (p == k) {
                System.out.println("YES");
                return;
            } else if (p < k) {
                if (v < n / 2) {
                    left = v + 1;
                } else {
                    right = v - 1;
                }
            } else {
                if (v < n / 2) {
                    right = v - 1;
                } else {
                    left = v + 1;
                }
            }
        }

        System.out.println("NO");
    }
}
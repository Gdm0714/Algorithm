import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            sum += h[i];
            cnt += h[i] / 2;
        }

        System.out.println((sum % 3 == 0 && cnt >= sum / 3) ? "YES" : "NO");
    }
}